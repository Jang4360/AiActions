package com.aiactions.backend.dto;

import com.aiactions.backend.entity.Template;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// 조회 데이터
@Getter
public class TemplateAdminResponseDTO {
    private UUID id;
    private String title;
    private String description;
    private String fileUrl;
    private List<String> tags;
    private LocalDateTime createdAt;

    public TemplateAdminResponseDTO(Template template) {
        this.id = template.getId();
        this.title = template.getTitle();
        this.description = template.getDescription();
        this.fileUrl = template.getFileUrl();
        this.tags = template.getTags();
        this.createdAt = template.getCreatedAt();
    }
}
