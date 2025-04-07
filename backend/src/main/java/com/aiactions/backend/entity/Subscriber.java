package com.aiactions.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "subscribers")
public class Subscriber {
    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    private LocalDateTime subscribedAt;
}
