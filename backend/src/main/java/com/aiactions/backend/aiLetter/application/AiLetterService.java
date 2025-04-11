package com.aiactions.backend.aiLetter.application;

import com.aiactions.backend.aiLetter.domain.AiLetter;
import com.aiactions.backend.aiLetter.repository.AiLetterRepository;
import com.aiactions.backend.aiLetter.web.dto.AiLetterDetailResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AiLetterService {
    private final AiLetterRepository aiLetterRepository;

    public AiLetterDetailResponseDTO getAiLetterDetailByCardId(UUID cardId) {
        AiLetter aiLetter = aiLetterRepository.findAiLetterByCardId(cardId)
                .orElseThrow(() -> new EntityNotFoundException("AiLetter not found with id:" + cardId));
        return new AiLetterDetailResponseDTO(aiLetter);
    }
}
