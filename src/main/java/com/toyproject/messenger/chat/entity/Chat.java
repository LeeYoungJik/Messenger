package com.toyproject.messenger.chat.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;

    private String message;

    private String sender;

    private String reciever;

    private Date sendTime;

    private String chatRoomId;

    @Builder
    public Chat( String message, String sender, String reciever, Date sendTime, String chatRoomId) {
        this.message = message;
        this.sender = sender;
        this.reciever = reciever;
        this.sendTime = sendTime;
        this.chatRoomId = chatRoomId;
    }

//
//    @Builder
//    public Chat sendChat(String sender, String reciever, String message){
//        this.sender = sender;
//        this.reciever = reciever;
//        this.message = message;
//        return this;
//    }

}
