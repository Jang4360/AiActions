package com.aiactions.backend.aiLetter.web.dto;

import lombok.Getter;

import java.util.List;

// 어드민 페이지 - aiLetter, card 수정 & 생성 DTO
@Getter
public class AiLetterAdminRequestDTO {
    // AiLetter
    private String title;
    private String content;
    private List<String> templateTitles;

    // Card
    private String cardName;
    private String cardDescription;
    private List<String> cardTags;
}
