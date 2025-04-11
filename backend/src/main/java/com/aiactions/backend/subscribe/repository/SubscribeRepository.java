package com.aiactions.backend.subscribe.repository;

import com.aiactions.backend.subscribe.domain.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SubscribeRepository extends JpaRepository<Subscriber, UUID> {
    boolean existsByEmail(String email);

    List<Subscriber> findAll();
}
