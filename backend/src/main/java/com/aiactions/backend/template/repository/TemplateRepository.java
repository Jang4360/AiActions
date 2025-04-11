package com.aiactions.backend.template.repository;

import com.aiactions.backend.template.domain.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TemplateRepository extends JpaRepository<Template, UUID> {

    // 전체 조회 (최신순)
    List<Template> findAllByOrderByCreatedAtDesc();

    // 태그 기반 필터 조회
    @Query("""
                SELECT t FROM Template t
                WHERE :tag IS NULL OR :tag IN elements(t.tags)
                ORDER BY t.createdAt DESC
            """)
    List<Template> findByTag(@Param("tag") String tag);

    // 제목 조회
    List<Template> findByTitleIn(List<String> titles);
}
