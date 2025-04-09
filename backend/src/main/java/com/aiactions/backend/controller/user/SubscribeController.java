package com.aiactions.backend.controller.user;

import com.aiactions.backend.dto.SubscribeRequestDTO;
import com.aiactions.backend.service.user.SubscribeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscribe")
@RequiredArgsConstructor
@CrossOrigin
public class SubscribeController {
    private final SubscribeService subscribeService;

    @PostMapping
    public ResponseEntity<Void> subscribe(@RequestBody @Valid SubscribeRequestDTO dto) {
        subscribeService.subscribe(dto.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
