package com.hackday.dailycommit.Commit.service.impl;

import com.hackday.dailycommit.Commit.dao.CommitDao;
import com.hackday.dailycommit.Commit.dao.TodayCommitDao;
import com.hackday.dailycommit.Commit.dto.Commit;
import com.hackday.dailycommit.Commit.dto.TodayCommit;
import com.hackday.dailycommit.Commit.service.TodayCommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodayCommitServiceImpl implements TodayCommitService{
    @Autowired
    TodayCommitDao todayCommitDao;

    @Autowired
    CommitDao commitDao;

    @Override
    public List<TodayCommit> getTodayCommits() {
        List<TodayCommit> todayCommits = todayCommitDao.selectTodayCommit();
        for(TodayCommit t : todayCommits){
            if(t.isChkCommit()) {
                List<Commit> userCommits = commitDao.selectUserCommits(t.getUserId());
                t.setCommitContents(userCommits);
            }
        }
        return todayCommits;
    }
}
