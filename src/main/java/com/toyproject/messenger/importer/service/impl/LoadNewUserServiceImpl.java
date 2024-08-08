package com.toyproject.messenger.importer.service.impl;

import com.toyproject.messenger.importer.entity.NewMessengerUser;
import com.toyproject.messenger.importer.repository.NewMessengerUserRepository;
import com.toyproject.messenger.importer.service.LoadNewUserService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@NoArgsConstructor
public class LoadNewUserServiceImpl implements LoadNewUserService {

    private NewMessengerUserRepository newMessengerUserRepository;

    @Transactional(readOnly = true)
    public List<NewMessengerUser> LoadAll(){
        return newMessengerUserRepository.findAll();
    }





}
