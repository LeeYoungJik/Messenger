package com.toyproject.messenger.importer.service;

import com.toyproject.messenger.importer.entity.NewMessengerUser;

import java.util.List;

public interface LoadNewUserService {
    List<NewMessengerUser> LoadAll();
}
