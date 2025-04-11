package com.aiactions.backend.template.application;

import com.aiactions.backend.template.repository.TemplateRepository;
import com.aiactions.backend.template.domain.Template;
import com.aiactions.backend.template.web.dto.TemplateAdminRequestDTO;
import com.aiactions.backend.template.web.dto.TemplateAdminResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TemplateAdminService {
    private final TemplateRepository templateRepository;

    // 기존 템플릿 조회
    public TemplateAdminResponseDTO getTemplate(UUID id) {
        Template template = templateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("template not found"));
        return new TemplateAdminResponseDTO(template);
    }

    // 새로운 템플릿 생성
    public void createTemplate(TemplateAdminRequestDTO dto) {
        Template template = new Template();
        template.setTitle(dto.getTitle());
        template.setDescription(dto.getDescription());
        template.setFileUrl(dto.getFileUrl());
        template.setTags(dto.getTags());
        template.setCreatedAt(LocalDateTime.now());

        templateRepository.save(template);
    }

    // 기존 템플릿 수정
    public void updateTemplate(UUID id, TemplateAdminRequestDTO dto) {
        Template template = templateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("template not found"));

        template.setTitle(dto.getTitle());
        template.setDescription(dto.getDescription());
        template.setFileUrl(dto.getFileUrl());
        template.setTags(dto.getTags());
    }

    // 기존 템플릿 삭제
    public void deleteTemplate(UUID id) {
        if (!templateRepository.existsById(id)) {
            throw new EntityNotFoundException("Template not found");
        }
        templateRepository.deleteById(id);
    }
}
