package com.hackday.dailycommit.Commit.dto;

import java.time.LocalDateTime;

public class TodayCommit {
    private Long id;
    private Long userId;
    private String githubId;
    private LocalDateTime commitDate;
    private boolean chkCommit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(LocalDateTime commitDate) {
        this.commitDate = commitDate;
    }

    public boolean isChkCommit() {
        return chkCommit;
    }

    public void setChkCommit(boolean chkCommit) {
        this.chkCommit = chkCommit;
    }

    public String getGithubId() {
        return githubId;
    }

    public void setGithubId(String githubId) {
        this.githubId = githubId;
    }

    @Override
    public String toString() {
        return "TodayCommit{" +
                "id=" + id +
                ", userId=" + userId +
                ", githubId='" + githubId + '\'' +
                ", commitDate=" + commitDate +
                ", chkCommit=" + chkCommit +
                '}';
    }
}
