package com.aiactions.backend.aiLetter.repository;

import com.aiactions.backend.aiLetter.domain.AiLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface AiLetterRepository extends JpaRepository<AiLetter, UUID> {

    @Query("""
            SELECT l FROM AiLetter l
            JOIN FETCH l.templates t
            JOIN Card c ON c.aiLetter = l
            WHERE c.id = :cardId
            """)
    Optional<AiLetter> findAiLetterByCardId(@Param("cardId") UUID cardId);
}
