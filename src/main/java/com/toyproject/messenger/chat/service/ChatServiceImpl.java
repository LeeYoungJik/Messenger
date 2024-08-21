package com.toyproject.messenger.chat.service;

import com.toyproject.messenger.chat.entity.Chat;
import com.toyproject.messenger.chat.repository.ChatRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

//@AllArgsConstructor
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService{

    private final ChatRepository chatRepository;

    @Override
    public Chat sendChatService(String sendUser, String recieveUser, String message) {

        Chat chat = Chat.builder().chatRoomId(UUID.randomUUID().toString())
                .reciever(recieveUser)
                .sender(sendUser)
                .message(message)
                .sendTime(new Date())
                .build();

        return chatRepository.save(chat);

    }
}
