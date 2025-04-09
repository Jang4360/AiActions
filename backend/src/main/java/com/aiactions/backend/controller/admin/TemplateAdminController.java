package com.aiactions.backend.controller.admin;

import com.aiactions.backend.dto.TemplateAdminRequestDTO;
import com.aiactions.backend.dto.TemplateAdminResponseDTO;
import com.aiactions.backend.service.amin.TemplateAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/admin/templates")
@RequiredArgsConstructor
@CrossOrigin
public class TemplateAdminController {
    private final TemplateAdminService templateAdminService;

    // 기본 템플릿 조회
    @GetMapping("/{id}")
    public ResponseEntity<TemplateAdminResponseDTO> getTemplate(@PathVariable UUID id) {
        TemplateAdminResponseDTO dto = templateAdminService.getTemplate(id);
        return ResponseEntity.ok(dto);
    }

    // 새로운 템플릿 생성
    @PostMapping
    public ResponseEntity<Void> createTemplate(@RequestBody TemplateAdminRequestDTO dto) {
        templateAdminService.createTemplate(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 기존 템플릿 수정
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTemplate(@PathVariable UUID id, @RequestBody TemplateAdminRequestDTO dto) {
        templateAdminService.updateTemplate(id,dto);
        return ResponseEntity.noContent().build();
    }

    // 기존 템플릿 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTemplate(@PathVariable UUID id) {
        templateAdminService.deleteTemplate(id);
        return ResponseEntity.noContent().build();
    }
}
