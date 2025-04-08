package com.aiactions.backend.controller.admin;

import com.aiactions.backend.dto.AiLetterAdminRequestDTO;
import com.aiactions.backend.dto.AiLetterAdminResponseDTO;
import com.aiactions.backend.service.amin.AiLetterAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/admin/cards")
@RequiredArgsConstructor
@CrossOrigin
public class AiLetterAdminController {
    private final AiLetterAdminService aiLetterAdminService;


    // 새로운 aiLetter,card 생성
    @PostMapping
    public ResponseEntity<Void> createAiLetterForCard(@RequestBody AiLetterAdminRequestDTO dto) {
        aiLetterAdminService.createAiLetterAndCard(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 기존 aiLetter 조회
    @GetMapping("/{id}")
    public ResponseEntity<AiLetterAdminResponseDTO> getAiLetter(@PathVariable UUID id) {
        AiLetterAdminResponseDTO dto = aiLetterAdminService.getAiLetterForEdit(id);
        return ResponseEntity.ok(dto);
    }

    // 기존 aiLetter,card 수정
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAiLetter(
            @PathVariable UUID id,
            @RequestBody AiLetterAdminRequestDTO dto
    ) {
        aiLetterAdminService.updateAiLetter(id,dto);
        return ResponseEntity.noContent().build();
    }

    // 기존 aiLetter,card 삭제
    public ResponseEntity<Void> deleteCardAndAiLetter(@PathVariable("id") UUID id) {
        aiLetterAdminService.deleteCardAndAiLetter(id);
        return ResponseEntity.noContent().build();
    }

}
