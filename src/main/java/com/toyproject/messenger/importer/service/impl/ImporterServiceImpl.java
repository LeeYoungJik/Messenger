package com.toyproject.messenger.importer.service.impl;

import com.toyproject.messenger.importer.entity.NewMessengerUser;
import com.toyproject.messenger.importer.repository.NewMessengerUserRepository;
import com.toyproject.messenger.importer.service.ImporterService;
import com.toyproject.messenger.importer.service.LoadNewUserService;
import com.toyproject.messenger.user.entity.MessengerUser;
import com.toyproject.messenger.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class ImporterServiceImpl implements ImporterService {

    private final NewMessengerUserRepository newMessengerUserRepository;

    private final UserServiceImpl userService;

    @Override
    @Transactional
    public String startUserImport() {

        List<MessengerUser> insertUser = new ArrayList<>();
        List<MessengerUser> updateUser = new ArrayList<>();
        List<MessengerUser> deleteUser = new ArrayList<>();

        List<NewMessengerUser> newUsers = newMessengerUserRepository.findAll();
        List<MessengerUser> users = userService.findAll();

        StringBuffer resultStringBuffer = new StringBuffer();

        for (NewMessengerUser loadUser : newUsers) {
            Optional<MessengerUser> messengerUserOtl = userService.findbyIdOptional(loadUser.getId());

            if (!messengerUserOtl.isPresent()) {//insert case
                insertUser.add(makeNewMessengeruser(loadUser));
            } else {
                MessengerUser messengerUser = messengerUserOtl.get();
                if (!updateChek(loadUser, messengerUser)) {//update case
                    updateUser.add(messengerUser.setUserInfo(loadUser));
                }
            }
        }

        HashMap<String, NewMessengerUser> deleteCheckList = new HashMap<>();
        newUsers.stream().forEach(user -> { deleteCheckList.put(user.getLoginId(), user); });
        deleteUser = users.stream().filter(e -> deleteCheckList.get(e.getLoginId()) == null).collect(Collectors.toList());

        log.info("import User Check end insert = {}, update = {}, delete = {}",insertUser.size(),updateUser.size(),deleteUser.size());

        userService.saveAll(insertUser);
//        userService.saveAll(updateUser);
        deleteUser.stream().forEach(e -> userService.delete(e.getID()));

        return resultStringBuffer.toString();
    }


    private MessengerUser makeNewMessengeruser(NewMessengerUser newMessengerUser) {
        return MessengerUser.builder().name(newMessengerUser.getName())
                .loginId(newMessengerUser.getLoginId())
                .loginPw(newMessengerUser.getLoginPw()).deptCode(newMessengerUser.getDeptCode())
                .deptname(newMessengerUser.getDeptName())
                .name(newMessengerUser.getName()).build();
    }


//    private MessengerUser updateMessengerUser(NewMessengerUser newMessengerUser){
//        MessengerUser messengerUser = userService.findbyId(newMessengerUser.getId());
//        return messengerUser.builder().name(newMessengerUser.getName())
//                .loginId(newMessengerUser.getLoginId())
//                .loginPw(newMessengerUser.getLoginPw()).deptCode(newMessengerUser.getDeptCode())
//                .deptname(newMessengerUser.getDeptName())
//                .name(newMessengerUser.getName()).build();
//    }


    private Boolean updateChek(NewMessengerUser newMessengerUser, MessengerUser messengerUser) {
        if (!newMessengerUser.getName().trim().equals(messengerUser.getName())
                || !newMessengerUser.getLoginPw().equals(messengerUser.getLoginPw())
                || !newMessengerUser.getDeptCode().equals(messengerUser.getDeptCode())
                || !newMessengerUser.getDeptName().equals(messengerUser.getDeptname())) {
            log.info("update case newUser id ={} , name ={}", newMessengerUser.getLoginId(), newMessengerUser.getDeptName());
            return false;
        }
        return true;
    }


}
