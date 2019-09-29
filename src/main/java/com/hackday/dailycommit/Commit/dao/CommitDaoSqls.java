package com.hackday.dailycommit.Commit.dao;

public class CommitDaoSqls {
    public static final String SELECT_USER_TODAY_COMMITS = "SELECT" +
            " id," +
            " user_id," +
            " repo," +
            " commit_content," +
            " commit_date" +
            " FROM commitInfo" +
            " WHERE user_id = :userId AND Date(commit_date) = DATE(NOW())";
}
