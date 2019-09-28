package com.hackday.dailycommit;

import com.hackday.dailycommit.Commit.dao.CommitDao;
import com.hackday.dailycommit.Commit.dto.Commit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommitDaoTest {
    @Autowired
    CommitDao commitDao;

    @Test
    public void insetCommit(){
        Commit newCommit = new Commit();
        newCommit.setCommitContent("나는 커밋이다.");
        newCommit.setUserId(Long.valueOf(1));
        commitDao.insertCommit(newCommit);
    }
}
