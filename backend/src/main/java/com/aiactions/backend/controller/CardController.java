package com.aiactions.backend.controller;

import com.aiactions.backend.dto.CardDTO;
import com.aiactions.backend.dto.CardSearchDTO;
import com.aiactions.backend.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    // 카드 전체 조회 (카드페이지로 이동시)
    @GetMapping("/all")
    public List<CardDTO> getAllCards() {
        return cardService.getAllCards();
    }


    // 카드 검색했을 때 조회
    @GetMapping
    public Page<CardDTO> getCards(@ModelAttribute CardSearchDTO condition) {
        return cardService.getCards(condition);
    }
}
