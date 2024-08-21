package com.toyproject.messenger.user.entity;

import com.toyproject.messenger.importer.entity.NewMessengerUser;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MessengerUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ID;

    String name;

    String loginId;

    String loginPw;

    String deptCode;

    String deptname;


    @Builder
    public MessengerUser(String name, String loginId, String loginPw, String deptCode, String deptname) {
        this.name = name;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.deptCode = deptCode;
        this.deptname = deptname;
    }


    public MessengerUser setUserInfo(NewMessengerUser newMessengerUser) {
        if(newMessengerUser.getName()!=null)
        this.name = newMessengerUser.getName();
        if(newMessengerUser.getLoginId()!=null)
        this.loginId = newMessengerUser.getLoginId();
        if(newMessengerUser.getLoginPw()!=null)
        this.loginPw = newMessengerUser.getLoginPw();
        if(newMessengerUser.getDeptCode()!=null)
        this.deptCode = newMessengerUser.getDeptCode();
        if(newMessengerUser.getDeptName()!=null)
        this.deptname = newMessengerUser.getDeptName();
        return this;
    }


    public void setUserInfo(MessengerUser messengerUser) {
        if (messengerUser.getName() != null)
            this.name = messengerUser.getName();
        if (messengerUser.getLoginId() != null)
            this.loginId = messengerUser.getLoginId();
        if (messengerUser.getLoginPw() != null)
            this.loginPw = messengerUser.getLoginPw();
        if (messengerUser.getDeptCode() != null)
            this.deptCode = messengerUser.getDeptCode();
        if (messengerUser.getDeptname() != null)
            this.deptname = messengerUser.getDeptname();
    }

//    public void setName(String name){
//        this.name=name;
//    }
}
