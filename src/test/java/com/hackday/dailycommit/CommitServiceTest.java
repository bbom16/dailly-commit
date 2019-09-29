package com.hackday.dailycommit;

import com.hackday.dailycommit.Commit.dto.Commit;
import com.hackday.dailycommit.Commit.service.CommitService;
import com.hackday.dailycommit.User.dto.User;
import com.hackday.dailycommit.User.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.TimeZone;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommitServiceTest {
    @Autowired
    CommitService commitService;

    @Autowired
    UserService userService;

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Test
    public void serviceTest(){
        List<User> users = userService.getAllUsers();
        commitService.insertCommit();
    }
}
