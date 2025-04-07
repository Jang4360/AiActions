package com.aiactions.backend.repository;

import com.aiactions.backend.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
    // 검색 기반 카드 조회
    @Query("""
            SELECT c FROM Card c
            WHERE (:keyword IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')))
            AND (:tag IS NULL OR :tag IN elements(c.tags))
            """)
    Page<Card> findByKeywordOrTag(
            @Param("keyword") String keyword,
            @Param("tag") String tag,
            Pageable pageable
    );

    // 전체 카드 조회
    List<Card> findAllByOrderByCreatedAtDesc();
}
