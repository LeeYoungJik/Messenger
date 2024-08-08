package com.toyproject.messenger.user.service;


import com.toyproject.messenger.exception.UserNotFoundException;
import com.toyproject.messenger.user.entity.MessengerUser;
import com.toyproject.messenger.user.repository.MessengerUserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl {

    private final MessengerUserRepository messengerUserRepository;


    //findAll은 값이 없을 경우 빈 List<>를 반환하기 때문에 optional처리를 하지 않아도 된다.
    @Transactional(readOnly = true)
    public List<MessengerUser> findAll() {
        List<MessengerUser> allUsers = messengerUserRepository.findAll();
        if (allUsers.isEmpty())
//            throw new Exception();
            log.info("findAll Users is empty");
        return allUsers;
    }

    @Transactional(readOnly = true)
    public MessengerUser findbyId(Long id) {
        MessengerUser messengerUser = messengerUserRepository.findById(id).orElseThrow(() -> new UserNotFoundException(String.format("User id %s is not found", id)));// Throw 추가해야함.
        return messengerUser;
    }


    public void delete(Long id){
        messengerUserRepository.delete(messengerUserRepository.findById(id).orElseThrow(() -> new UserNotFoundException((String.format("User id %s is not found",id)))));
    }

    public void saveAll(List<MessengerUser> messengerUserList){
        messengerUserRepository.saveAll(messengerUserList);
    }

    public MessengerUser save(MessengerUser messengerUser){
        MessengerUser newUser = messengerUserRepository.save(messengerUser);
        return newUser;
    }


    @Transactional//굳이 안 써도 될듯.
    public void update(MessengerUser messengerUser){
        messengerUserRepository.findById(messengerUser.getID());
    }





}
