package com.toyproject.messenger;

import com.toyproject.messenger.importer.entity.NewMessengerUser;
import com.toyproject.messenger.user.entity.MessengerUser;
import com.toyproject.messenger.user.repository.MessengerUserRepository;
import jakarta.persistence.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;

@SpringBootTest
//@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class JpaTest {

    @Autowired
    private MessengerUserRepository messengerUserRepository;

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Test
    @Rollback(value = false)
    public void testJpa(){

        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //new case
//        MessengerUser member1 = MessengerUser.builder().loginId("20240814leeyj").loginPw("leeyj").name("leeyj").deptCode("leeyj").deptname("leeyj").build();
//        em.persist(member1);

//        MessengerUser messengerUser = em.find(MessengerUser.class, 108L);
//        em.remove(messengerUser);
//        messengerUser.setUserInfo(MessengerUser.builder().name("이영직").build());
        //messengetUser.setName("정수아");


        MessengerUser messengerUser = em.find(MessengerUser.class, 111L);
        em.detach(messengerUser);
        em.merge(messengerUser);



////        MessengerUser member1 = MessengerUser.builder().loginId("leeyj").loginPw("leeyj").name("leeyj").deptCode("leeyj").deptname("leeyj").build();
//
////        MessengerUser member1 = em.find(MessengerUser.class, "106");
////        em.detach(member1);
//
//        System.out.println("Jpa persist 영속성");
//
//        MessengerUser mdh = MessengerUser.builder().loginId("mdh444").build();
////        member1.setUserInfo(mdh);
//
//
//        MessengerUser member2 = em.find(MessengerUser.class, "106");
//        MessengerUser mdh222 = MessengerUser.builder().loginId("mdh333").build();
//        member2.setUserInfo(mdh222);
//
//        em.merge(member2);
////        em.merge(member1);
////        em.flush();
//        System.out.println("Jpa persist flush");
////        em.merge(member1);
//
//        em.flush();
        System.out.println("#### tr end before");
        tx.commit();  //tr 이
        System.out.println("#### tr end after");

    }



}
