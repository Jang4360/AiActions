package com.aiactions.backend.dto;

import com.aiactions.backend.entity.AiLetter;
import com.aiactions.backend.entity.Template;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

// 유저 페이지 - 기본 aiLetter 조회 DTO
public class AiLetterDetailResponseDTO {
    private UUID id;
    private String title;
    private String content;
    private List<String> templateTitles;

    public AiLetterDetailResponseDTO(AiLetter aiLetter) {
        this.id = aiLetter.getId();
        this.title = aiLetter.getTitle();
        this.content = aiLetter.getContent();
        this.templateTitles = aiLetter.getTemplates()
                .stream()
                .map(Template::getTitle)
                .collect(Collectors.toList()); // template 의 title 만 리스트로 가져와 넘김
    }
}
