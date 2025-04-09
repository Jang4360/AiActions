package com.aiactions.backend.dto;

import com.aiactions.backend.entity.Template;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class TemplateDTO {
    private UUID id;
    private String title;
    private String description;
    private String fileUrl;
    private List<String> tags;
    private LocalDateTime createdAt;

    public TemplateDTO(Template template) {
        this.id = template.getId();
        this.title = template.getTitle();
        this.description = template.getDescription();
        this.fileUrl = template.getFileUrl();
        this.tags = template.getTags();
        this.createdAt = template.getCreatedAt();
    }
}

