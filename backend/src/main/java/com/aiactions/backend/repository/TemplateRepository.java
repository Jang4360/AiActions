package com.aiactions.backend.repository;

import com.aiactions.backend.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TemplateRepository extends JpaRepository<Template, UUID> {
    List<Template> findByTitleIn(List<String> titles);
}
