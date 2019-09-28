package com.hackday.dailycommit.User.service;

import com.hackday.dailycommit.User.dto.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User insertUser(User user);
}
