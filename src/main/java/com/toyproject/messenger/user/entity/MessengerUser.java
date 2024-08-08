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



    public MessengerUser setNewMessengerUser(NewMessengerUser newMessengerUser){
        this.name = newMessengerUser.getName();
        this.loginId = newMessengerUser.getLoginId();
        this.loginPw = newMessengerUser.getLoginPw();
        this.deptCode = newMessengerUser.getDeptCode();
        this.deptname = newMessengerUser.getDeptName();
        return this;
    }
}
