package com.hackday.dailycommit;

import com.hackday.dailycommit.User.dto.User;
import com.hackday.dailycommit.User.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void getUser(){
        System.out.println(userService.getAllUsers());
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setGithubId("testtesttest");
        user.setGithubKey("keyfsfsfsfsf");
        user.setEnableFlag(true);
        System.out.println(userService.insertUser(user));
    }
}
