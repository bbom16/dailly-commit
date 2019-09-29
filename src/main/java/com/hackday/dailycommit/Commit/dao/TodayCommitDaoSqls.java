package com.hackday.dailycommit.Commit.dao;

public class TodayCommitDaoSqls {
    public static final String SELECT_COMMIT_TODAY = "SELECT" +
            " u.id AS user_id," +
            " u.github_id," +
            " CASE WHEN today.user_id is null THEN false" +
            " WHEN today.user_id is not null THEN true END AS chk_commit" +
            " FROM userInfo u" +
            " LEFT OUTER JOIN (SELECT user_id FROM commitInfo WHERE Date(commit_date) = DATE(NOW()) GROUP BY user_id)today ON today.user_id = u.id" +
            " WHERE u.enable_flag = true";
}

