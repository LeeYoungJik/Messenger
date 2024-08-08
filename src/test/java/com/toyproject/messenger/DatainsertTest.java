package com.toyproject.messenger;

import com.mysema.commons.lang.Assert;
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


    @Test
    public void insertMeseengeruser(){

        List<MessengerUser> messengerUserList = new ArrayList<>();
        for(int i= 0; i<100; i++) {
            MessengerUser userTest = MessengerUser.builder()
//                    .id((long) i)
                    .name("Test").deptCode("deptCode").deptname("TestDetpName").loginId("test01").loginPw("12345").build();
            MessengerUser saveUser = userService.save(userTest);
            assertThat(userTest).isEqualTo(saveUser);
        }
//        userService.saveAll(messengerUserList);

        //리스트에 넣기만 해도 tr이 끝나면 save가 된다?
    }


    @Transactional
    @Test
    public void upateTest(){
        MessengerUser messengerUser = userService.findbyId(3L);
    }

}
