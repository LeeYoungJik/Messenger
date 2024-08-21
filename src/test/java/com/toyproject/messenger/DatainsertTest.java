package com.toyproject.messenger;

import com.mysema.commons.lang.Assert;
import com.toyproject.messenger.importer.entity.NewMessengerUser;
import com.toyproject.messenger.importer.repository.NewMessengerUserRepository;
import com.toyproject.messenger.importer.service.impl.ImporterServiceImpl;
import com.toyproject.messenger.user.entity.MessengerUser;
import com.toyproject.messenger.user.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class DatainsertTest {


    @Autowired
    UserServiceImpl userService;

    @Autowired
    NewMessengerUserRepository newMessengerUserRepository;

    @Autowired
    ImporterServiceImpl importerService;


    @Test
    public void insertMeseengeruser() {

        List<MessengerUser> messengerUserList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            MessengerUser userTest = MessengerUser.builder()
//                    .id((long) i)
                    .name("Test").deptCode("deptCode").deptname("TestDetpName").loginId("test01").loginPw("12345").build();
            MessengerUser saveUser = userService.save(userTest);
//            assertThat(userTest).isEqualTo(saveUser);
        }

    }

    @Test
    public void inserNewMeseengeruser() {

        List<MessengerUser> messengerUserList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            NewMessengerUser userTest = NewMessengerUser.builder()
                    .name("Test")
                    .deptCode("deptCode")
                    .deptName("aaaaa")
                    .loginId("Test11")
                    .loginPw("test22")
                    .build();

            newMessengerUserRepository.save(userTest);
        }

    }


    @Test
    @Transactional
    public void upateTest() {
//        MessengerUser messengerUser = userService.findbyId(3L);
//        MessengerUser updateTest = MessengerUser.builder().deptname("Test3333").deptCode("@33333@@@").build();
//        messengerUser.edit(updateTest);
//        MessengerUser save = userService.save(messengerUser);
        System.out.println("TR out####");

    }


    @Transactional
    public void tep1() {
        MessengerUser messengerUser = userService.findbyId(3L);
        MessengerUser updateTest = MessengerUser.builder().deptname("Test22222").deptCode("@222@@@").build();
//        messengerUser.edit(updateTest);

    }

    @Test
    public void importerTest() {
        importerService.startUserImport();
    }



    @Test
    public void jpaTest() {

        MessengerUser messengerUser = userService.findbyId(1L);
        MessengerUser test222 = MessengerUser.builder().loginId("Test222").build();
        messengerUser.setUserInfo(test222);

        MessengerUser TestmessengerUser = userService.findbyId(1L);

        System.out.println("TestUser LoginId ="+TestmessengerUser.getLoginId());

        userService.flush();

        MessengerUser TestmessengerUser2 = userService.findbyId(1L);
        System.out.println("TestUser LoginId ="+TestmessengerUser2.getLoginId());


        System.out.println("###End####");
//        MessengerUser TestmessengerUser = userService.findbyId(1L);




    }

}
