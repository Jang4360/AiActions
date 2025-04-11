package com.aiactions.backend.subscribe.application;

import com.aiactions.backend.subscribe.domain.Subscriber;
import com.aiactions.backend.subscribe.repository.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscribeService {
    private final SubscribeRepository subscribeRepository;

    // 구독자 등록
    public void subscribe(String email) {
        if (subscribeRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("이미 구독된 이메일입니다.");
        }

        Subscriber subscriber = new Subscriber(email);
        subscribeRepository.save(subscriber);
    }

    // 메일 발송
    @Scheduled(cron = "0 0 10 ? * WED\", zone = \"Asia/Seoul")
    public void sendWeeklyNewsLetter() {
        List<Subscriber> subscribers = subscribeRepository.findAll();

        // 실제 메일 발송 로직 대체 부분
        for (Subscriber subscriber : subscribers) {
            System.out.println("📧 메일 전송: " + subscriber.getEmail());
            // mailService.send(subscriber.getEmail(), subject, content);
        }
    }
}
