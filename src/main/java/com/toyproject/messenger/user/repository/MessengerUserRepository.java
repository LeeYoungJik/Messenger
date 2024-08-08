package com.toyproject.messenger.user.repository;

import com.toyproject.messenger.user.entity.MessengerUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessengerUserRepository extends JpaRepository<MessengerUser, Long> {


}
