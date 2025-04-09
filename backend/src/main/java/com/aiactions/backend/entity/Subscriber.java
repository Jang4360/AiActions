package com.aiactions.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "subscribers")
@Getter
public class Subscriber {
    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    private LocalDateTime subscribedAt;

    public Subscriber(String email) {
        this.email=email;
        this.subscribedAt = LocalDateTime.now();
    }
}
