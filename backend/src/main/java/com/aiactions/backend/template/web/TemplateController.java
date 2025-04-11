package com.aiactions.backend.template.web;

import com.aiactions.backend.template.application.TemplateService;
import com.aiactions.backend.template.web.dto.TemplateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
@RequiredArgsConstructor
@CrossOrigin
public class TemplateController {
    private final TemplateService templateService;

    // 전체 템플릿 조회
    @GetMapping("/all")
    public ResponseEntity<List<TemplateDTO>> getAllTemplates() {
        return ResponseEntity.ok(templateService.getAllTemplates());
    }

    // 태그 기반 템플릿 필터링 조회
    @GetMapping
    public ResponseEntity<List<TemplateDTO>> getTemplatesByTag(@RequestParam(required = false)String tag){
        return ResponseEntity.ok(templateService.getTemplatesByTag(tag));
    }
}
