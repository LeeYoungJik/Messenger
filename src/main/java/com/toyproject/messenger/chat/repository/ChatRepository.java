package com.toyproject.messenger.chat.repository;

import com.toyproject.messenger.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findBySender(String sender);
}
