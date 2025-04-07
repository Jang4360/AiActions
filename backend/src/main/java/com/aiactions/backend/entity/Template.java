package com.aiactions.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "templates")
@Getter @Setter
public class Template {
    @Id
    @GeneratedValue
    private UUID id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String fileUrl;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> tags = new ArrayList<>();

    private LocalDateTime createdAt;

    // 연관 관계
    @ManyToMany(mappedBy = "templates")
    private List<AiLetter> aiLetters = new ArrayList<>();
}
