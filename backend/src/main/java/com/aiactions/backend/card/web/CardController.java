package com.aiactions.backend.card.web;

import com.aiactions.backend.card.application.CardService;
import com.aiactions.backend.card.web.dto.CardDTO;
import com.aiactions.backend.card.web.dto.CardSearchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    // 카드 전체 조회 (카드페이지로 이동시)
    @GetMapping("/all")
    public ResponseEntity<List<CardDTO>> getAllCards() {
        List<CardDTO> result = cardService.getAllCards();
        return ResponseEntity.of(Optional.ofNullable(result));
    }


    // 카드 검색했을 때 조회
    @GetMapping
    public ResponseEntity<Page<CardDTO>> getCards(@ModelAttribute CardSearchDTO condition) {
        Page<CardDTO> result = cardService.getCards(condition);
        return ResponseEntity.of(Optional.ofNullable(result));
    }
}
