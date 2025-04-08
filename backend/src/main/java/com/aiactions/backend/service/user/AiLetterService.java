package com.aiactions.backend.service.user;

import com.aiactions.backend.dto.AiLetterDetailResponseDTO;
import com.aiactions.backend.entity.AiLetter;
import com.aiactions.backend.repository.AiLetterRepository;
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
