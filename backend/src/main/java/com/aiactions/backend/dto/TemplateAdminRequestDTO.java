package com.aiactions.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// 생성, 수정 데이터
@Getter @Setter
@NoArgsConstructor
public class TemplateAdminRequestDTO {
    private String title;
    private String description;
    private String fileUrl;
    private List<String> tags;
}
