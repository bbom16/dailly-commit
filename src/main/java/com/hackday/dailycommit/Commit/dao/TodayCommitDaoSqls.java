package com.hackday.dailycommit.Commit.dao;

public class TodayCommitDaoSqls {
    public static final String SELECT_ALL_TODAY_COMMITS = "SELECT" +
            " id," +
            " user_id," +
            " commit_date," +
            " chk_commit" +
            " FROM chkCommit";

    public static final String SELECT_TODAY_COMMIT_USR="";
    public static final String SELECT_TODAY_COMMIT_DATE="";
}
