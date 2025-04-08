package com.aiactions.backend.service.amin;

import com.aiactions.backend.dto.AiLetterAdminRequestDTO;
import com.aiactions.backend.dto.AiLetterAdminResponseDTO;
import com.aiactions.backend.entity.AiLetter;
import com.aiactions.backend.entity.Card;
import com.aiactions.backend.entity.CardImageMapping;
import com.aiactions.backend.entity.Template;
import com.aiactions.backend.repository.AiLetterRepository;
import com.aiactions.backend.repository.CardImageMappingRepository;
import com.aiactions.backend.repository.CardRepository;
import com.aiactions.backend.repository.TemplateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AiLetterAdminService {
    private final AiLetterRepository aiLetterRepository;
    private final TemplateRepository templateRepository;
    private final CardRepository cardRepository;
    private final CardImageMappingRepository cardImageMappingRepository;

    // 새로 AiLetter,Card 생성
    public void createAiLetterAndCard(AiLetterAdminRequestDTO dto) {
        // 템플릿 조회
        List<Template> templates = templateRepository.findByTitleIn(dto.getTemplateTitles());
        // aiLetter 생성
        AiLetter aiLetter = new AiLetter();
        aiLetter.setTitle(dto.getTitle());
        aiLetter.setContent(dto.getContent());
        aiLetter.setPublishedAt(LocalDateTime.now());
        aiLetter.setTemplates(templates);

        aiLetterRepository.save(aiLetter);
        String tag = dto.getCardTags().isEmpty() ? "default" : dto.getCardTags().get(0);
        String imageUrl = cardImageMappingRepository.findByTag(tag)
                .map(CardImageMapping::getImageUrl)
                .orElse("https://default-image-url.com/default.jpg");

        // card 생성
        Card card = new Card();
        card.setName(dto.getCardName());
        card.setDescription(dto.getCardDescription());
        card.setTags(dto.getCardTags());
        card.setCreatedAt(LocalDateTime.now());
        card.setImageUrl(imageUrl);
        card.setAiLetter(aiLetter);

        cardRepository.save(card);
    }

    // 기존 카드 AiLetter 조회
    public AiLetterAdminResponseDTO getAiLetterForEdit(UUID cardId) {
        AiLetter aiLetter = aiLetterRepository.findAiLetterByCardId(cardId)
                .orElseThrow(() -> new EntityNotFoundException("card or aiLetter not found:" + cardId));
        return new AiLetterAdminResponseDTO(aiLetter);
    }

    // 기존 AiLetter, Card 수정
    public void updateAiLetter(UUID cardId, AiLetterAdminRequestDTO dto) {
        // AiLetter 필드 수정
        AiLetter aiLetter = aiLetterRepository.findAiLetterByCardId(cardId)
                .orElseThrow(() -> new EntityNotFoundException("card or aiLetter not found"+ cardId));

        aiLetter.setTitle(dto.getTitle());
        aiLetter.setContent(dto.getContent());

        // 템플릿 타이틀 기반으로 템플릿 조회 후 aiLetter 에 설정
        List<Template> templates = templateRepository.findByTitleIn(dto.getTemplateTitles());
        aiLetter.setTemplates(templates);

        // Card 필드 수정
        Card card = aiLetter.getCard();
        if (card == null) {
            throw new EntityNotFoundException("card not found for this AiLetter");
        }

        card.setName(dto.getCardName());
        card.setDescription(dto.getCardDescription());
        card.setTags(dto.getCardTags());

        // 카드 태그 기반 이미지 URL 재매핑
        String primaryTag = dto.getCardTags().isEmpty() ? "default" : dto.getCardTags().get(0);
        String imageUrl = cardImageMappingRepository.findByTag(primaryTag)
                .map(CardImageMapping::getImageUrl)
                .orElse("https://default-image-url.com/default.jpg");

        card.setImageUrl(imageUrl);
    }

    // 기존 AiLetter, Card 삭제
    @Transactional
    public void deleteCardAndAiLetter(UUID cardId) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new EntityNotFoundException("card not found with id: " + cardId));

        // 1. AiLetter 직접 제거
        AiLetter aiLetter = card.getAiLetter();
        if (aiLetter != null) {
            aiLetterRepository.delete(aiLetter);
        }

        // 2. Card 제거
        cardRepository.delete(card);
    }

}
