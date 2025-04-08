package com.aiactions.backend.dto;

import com.aiactions.backend.entity.AiLetter;
import com.aiactions.backend.entity.Card;
import com.aiactions.backend.entity.Template;
import lombok.Getter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

// 어드민 페이지 - 기존 aiLetter,card 조회 DTO
@Getter
public class AiLetterAdminResponseDTO {
    private UUID id;
    private String title;
    private String content;
    private List<String> templateTitles;

    private String cardName;
    private String cardDescription;
    private List<String> cardTags;

    public AiLetterAdminResponseDTO(AiLetter aiLetter) {
        this.id = aiLetter.getId();
        this.title = aiLetter.getTitle();
        this.content = aiLetter.getContent();
        this.templateTitles = aiLetter.getTemplates()
                .stream()
                .map(Template::getTitle)
                .collect(Collectors.toList());

        Card card = aiLetter.getCard();
        if (card != null) {
            this.cardName = card.getName();
            this.cardDescription = card.getDescription();
            this.cardTags = card.getTags();
        }
    }
}
