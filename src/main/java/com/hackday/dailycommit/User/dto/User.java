package com.hackday.dailycommit.User.dto;

public class User {
    private Long id;
    private String githubId;
    private String githubKey;
    private boolean enableFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGithubId() {
        return githubId;
    }

    public void setGithubId(String githubId) {
        this.githubId = githubId;
    }

    public String getGithubKey() {
        return githubKey;
    }

    public void setGithubKey(String githubKey) {
        this.githubKey = githubKey;
    }

    public boolean isEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(boolean enableFlag) {
        this.enableFlag = enableFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", githubId='" + githubId + '\'' +
                ", githubKey='" + githubKey + '\'' +
                ", enableFlag=" + enableFlag +
                '}';
    }
}
