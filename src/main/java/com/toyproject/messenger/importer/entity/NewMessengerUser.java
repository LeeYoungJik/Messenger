package com.toyproject.messenger.importer.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NewMessengerUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String loginId;

    private String loginPw;

    private String deptCode;

    private String deptName;


    @Builder
    public NewMessengerUser(String name, String loginId, String loginPw, String deptCode, String deptName) {
        this.name = name;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.deptCode = deptCode;
        this.deptName = deptName;
    }
}
