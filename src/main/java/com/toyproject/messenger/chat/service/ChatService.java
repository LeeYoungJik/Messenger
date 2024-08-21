package com.toyproject.messenger.chat.service;

import com.toyproject.messenger.chat.entity.Chat;

public interface ChatService {
    Chat sendChatService(String sendUser, String recieveUser, String message);
}
