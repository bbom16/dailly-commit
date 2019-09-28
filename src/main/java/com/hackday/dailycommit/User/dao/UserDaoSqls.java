package com.hackday.dailycommit.User.dao;

public class UserDaoSqls {
    public static final String SELECT_ALL_USERS = "SELECT id, " +
            " github_id," +
            " github_key," +
            " enable_flag" +
            " FROM userInfo" +
            " WHERE enable_flag = true";
}
