package com.aiactions.backend.service;

import com.aiactions.backend.dto.CardDTO;
import com.aiactions.backend.dto.CardSearchDTO;
import com.aiactions.backend.entity.Card;
import com.aiactions.backend.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    // 카드 전체 조회
    public List<CardDTO> getAllCards() {
        List<Card> cards = cardRepository.findAllByOrderByCreatedAtDesc();
        return cards.stream()
                .map(CardDTO::new)
                .toList();
    }

    // 카드 검색했을 때 조회
    public org.springframework.data.domain.Page<CardDTO> getCards(CardSearchDTO condition) {
        Pageable pageable = (Pageable) PageRequest.of(condition.getPage(), condition.getSize(), Sort.by("createdAt").descending());

        Page<Card> cards = cardRepository.findByKeywordOrTag(
                condition.getKeyword(),
                condition.getTag(),
                pageable
        );
        return cards.map(CardDTO::new);
    }
}
