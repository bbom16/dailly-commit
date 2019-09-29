package com.hackday.dailycommit.Commit.dto;

import java.time.LocalDate;
import java.util.List;

public class TodayCommit {
    private Long userId;
    private String githubId;
    private List<Commit> commitContents;
    private boolean chkCommit;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getGithubId() {
        return githubId;
    }

    public void setGithubId(String githubId) {
        this.githubId = githubId;
    }

    public boolean isChkCommit() {
        return chkCommit;
    }

    public void setChkCommit(boolean chkCommit) {
        this.chkCommit = chkCommit;
    }

    public List<Commit> getCommitContents() {
        return commitContents;
    }

    public void setCommitContents(List<Commit> commitContents) {
        this.commitContents = commitContents;
    }

    @Override
    public String toString() {
        return "TodayCommit{" +
                "userId=" + userId +
                ", githubId='" + githubId + '\'' +
                ", commitContents=" + commitContents +
                ", chkCommit=" + chkCommit +
                '}';
    }
}
