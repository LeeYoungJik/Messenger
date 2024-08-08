package com.toyproject.messenger.importer.repository;

import com.toyproject.messenger.importer.entity.NewMessengerUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewMessengerUserRepository extends JpaRepository<NewMessengerUser, Long> {
}
