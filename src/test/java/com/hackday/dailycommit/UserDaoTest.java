package com.hackday.dailycommit;

import com.hackday.dailycommit.User.dao.UserDao;
import com.hackday.dailycommit.User.dto.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void selectAll() throws Exception{
        List<User> users = userDao.selectUserList();
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() throws Exception{
        User newUser = new User();
        newUser.setGithubId("testdd");
        newUser.setGithubKey("hihihihi");
        Long id = userDao.insertUser(newUser);
        System.out.println("insert id:  " + id +"\nnewUser : "+ newUser);
    }
}
