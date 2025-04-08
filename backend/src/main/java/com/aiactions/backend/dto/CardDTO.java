package com.aiactions.backend.dto;

import com.aiactions.backend.entity.Card;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// 유저 페이지 - 기존 card 전체 조회 DTO
@Getter
public class CardDTO {
    private UUID id;
    private String name;
    private String description;
    private List<String> tags;
    private String imageUrl;
    private LocalDateTime createdAt;

    public CardDTO(Card card) {
        this.id = card.getId();
        this.name = card.getName();
        this.description = card.getDescription();
        this.tags = card.getTags();
        this.imageUrl = card.getImageUrl();
        this.createdAt = card.getCreatedAt();
    }
}
