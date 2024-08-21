package com.toyproject.messenger.user.controller;

import com.toyproject.messenger.user.entity.MessengerUser;
import com.toyproject.messenger.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/User")
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/Test")
    @Transactional
    public String aaa(){
        MessengerUser messengerUser = userService.findbyId(3L);
        messengerUser.setUserInfo(MessengerUser.builder().loginId("Controller").loginPw("ControllerPW").build());
        return "aaaa";
    }
}
