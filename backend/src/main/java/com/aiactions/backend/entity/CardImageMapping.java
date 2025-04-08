package com.aiactions.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "card_image_mapping")
@Getter @Setter
@NoArgsConstructor
public class CardImageMapping {
    @Id
    private String tag;
    private String imageUrl;
}
