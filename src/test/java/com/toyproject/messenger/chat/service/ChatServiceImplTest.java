package com.toyproject.messenger.chat.service;

import com.toyproject.messenger.chat.entity.Chat;
import com.toyproject.messenger.chat.repository.ChatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatServiceImplTest {

    @Autowired
    ChatServiceImpl chatService;

    @Autowired
    ChatRepository chatRepository;

    @Test
    public void Test(){

        for(int i=0; i<100; i++) {
            Chat chat = chatService.sendChatService("leeyj", "mdh", "helloWorld");

            System.out.println("####LYJ i= "+i+ " //  chatid = "+chat.getChatId());
        }


    }



    @Test
    public void Test2(){

        List<Chat> leeyj  = chatRepository.findBySender("leeyj");
        leeyj.stream().forEach(e-> System.out.println("####Leeyj "+e.getMessage()));

    }

}