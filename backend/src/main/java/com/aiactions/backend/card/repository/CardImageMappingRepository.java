package com.aiactions.backend.card.repository;

import com.aiactions.backend.card.domain.CardImageMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardImageMappingRepository extends JpaRepository<CardImageMapping,String> {
    Optional<CardImageMapping> findByTag(String tag);
}
