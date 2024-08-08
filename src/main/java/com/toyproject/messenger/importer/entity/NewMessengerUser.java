package com.toyproject.messenger.importer.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NewMessengerUser {

    @Id
    private Long id;

    private String name;

    private String loginId;

    private String loginPw;

    private String deptCode;

    private String deptName;


}
