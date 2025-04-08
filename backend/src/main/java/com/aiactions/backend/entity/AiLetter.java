package com.aiactions.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ai_letters")
@Getter @Setter
public class AiLetter {
    @Id @GeneratedValue
    private UUID id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime publishedAt;

    // 연관 관계 (join table 생성)
    @ManyToMany
    @JoinTable(
            name = "ai_letter_templates",
            joinColumns = @JoinColumn(name = "ai_letter_id"),
            inverseJoinColumns = @JoinColumn(name = "template_id")
    )
    private List<Template> templates = new ArrayList<>();

    // 연관 레터
    @OneToOne
    @JoinColumn(name = "card_id")
    private Card card;
}
