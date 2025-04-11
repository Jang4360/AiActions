package com.aiactions.backend.template.application;

import com.aiactions.backend.template.repository.TemplateRepository;
import com.aiactions.backend.template.web.dto.TemplateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TemplateService {
    private final TemplateRepository templateRepository;

    // 전체 템플릿 조회
    public List<TemplateDTO> getAllTemplates() {
        return templateRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(TemplateDTO::new)
                .toList();
    }

    // 태그 기반 템플릿 조회
    public List<TemplateDTO> getTemplatesByTag(String tag) {
        return templateRepository.findByTag(tag)
                .stream()
                .map(TemplateDTO::new)
                .toList();
    }
}
