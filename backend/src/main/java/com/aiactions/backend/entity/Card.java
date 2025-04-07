package com.aiactions.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cards")
@Getter @Setter
public class Card {
    @Id @GeneratedValue
    private UUID id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime createdAt;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> tags = new ArrayList<>();

    private String imageUrl;

    // 연관 레터
    @OneToOne
    @JoinColumn(name = "ai_letter_id")
    private AiLetter aiLetter;
}
