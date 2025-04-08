package com.aiactions.backend.repository;

import com.aiactions.backend.entity.CardImageMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardImageMappingRepository extends JpaRepository<CardImageMapping,String> {
    Optional<CardImageMapping> findByTag(String tag);
}
