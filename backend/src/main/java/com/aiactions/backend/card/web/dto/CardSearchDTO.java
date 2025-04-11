package com.aiactions.backend.card.web.dto;

import lombok.Getter;

// 유저 페이지 - 기존 card 검색 조회 DTO
@Getter
public class CardSearchDTO {
    private String keyword;
    private String tag;
    private int page = 1;
    private int size = 12;
}
