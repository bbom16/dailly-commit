package com.hackday.dailycommit.Commit.dto;

import java.time.LocalDateTime;

public class Commit {
    private Long userId;
    private String repo;
    private String commitContent;
    private LocalDateTime commitDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getCommitContent() {
        return commitContent;
    }

    public void setCommitContent(String commitContent) {
        this.commitContent = commitContent;
    }

    public LocalDateTime getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(LocalDateTime commitDate) {
        this.commitDate = commitDate;
    }

    @Override
    public String toString() {
        return "Commit{" +
                "userId=" + userId +
                ", repo='" + repo + '\'' +
                ", commitContent='" + commitContent + '\'' +
                ", commitDate=" + commitDate +
                '}';
    }
}
