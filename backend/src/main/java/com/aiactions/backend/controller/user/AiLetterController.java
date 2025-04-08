package com.aiactions.backend.controller.user;

import com.aiactions.backend.dto.AiLetterDetailResponseDTO;
import com.aiactions.backend.service.user.AiLetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/cards")
@RequiredArgsConstructor
@CrossOrigin
public class AiLetterController {
    private final AiLetterService aiLetterService;

    // 기존 aiLetter 조회
    @GetMapping("/{id}")
    public ResponseEntity<AiLetterDetailResponseDTO> getAiLetterDetail(@PathVariable UUID id) {
        AiLetterDetailResponseDTO dto = aiLetterService.getAiLetterDetailByCardId(id);
        return ResponseEntity.ok(dto);
    }
}
