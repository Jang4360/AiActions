package com.aiactions.backend.dto;

import lombok.Getter;

@Getter
public class CardSearchDTO {
    private String keyword;
    private String tag;
    private int page = 1;
    private int size = 12;
}
