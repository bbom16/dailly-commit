package com.hackday.dailycommit.Commit.service;

import com.hackday.dailycommit.Commit.dto.TodayCommit;

import java.util.List;

public interface TodayCommitService {
    public List<TodayCommit> getTodayCommits();
}
