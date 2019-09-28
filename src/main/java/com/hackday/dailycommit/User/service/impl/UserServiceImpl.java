package com.hackday.dailycommit.User.service.impl;

import com.hackday.dailycommit.User.dao.UserDao;
import com.hackday.dailycommit.User.dto.User;
import com.hackday.dailycommit.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.selectUserList();
    }

    @Transactional
    @Override
    public User insertUser(User user) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            restTemplate.getForObject("https://api.github.com/users/" + user.getGithubId(), String.class);
            user.setEnableFlag(true);
            Long id = userDao.insertUser(user);
            user.setId(id);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            user = null;
        }

        return user;
    }

}
