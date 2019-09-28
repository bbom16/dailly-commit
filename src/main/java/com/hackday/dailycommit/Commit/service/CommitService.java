package com.hackday.dailycommit.Commit.service;

import com.hackday.dailycommit.Commit.dto.Commit;
import com.hackday.dailycommit.User.dto.User;

import java.util.List;

public interface CommitService {
    public Commit insertCommit(List<User> users);
}
