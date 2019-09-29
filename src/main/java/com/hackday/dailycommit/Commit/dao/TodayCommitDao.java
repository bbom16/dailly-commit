package com.hackday.dailycommit.Commit.dao;

import com.hackday.dailycommit.Commit.dto.TodayCommit;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.util.Collections;
import java.util.List;

import static com.hackday.dailycommit.Commit.dao.TodayCommitDaoSqls.*;

@Repository
public class TodayCommitDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<TodayCommit> todayCommitRowMapper = BeanPropertyRowMapper.newInstance(TodayCommit.class);

    public TodayCommitDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("chkCommit").usingGeneratedKeyColumns("id");
    }

    public List<TodayCommit> selectTodayCommit(){
        return jdbc.query(SELECT_COMMIT_TODAY, Collections.EMPTY_MAP, todayCommitRowMapper);
    }

    public Long insertTodayCommit(TodayCommit todayCommit){
        SqlParameterSource params = new BeanPropertySqlParameterSource(todayCommit);
        return insertAction.executeAndReturnKey(params).longValue();
    }
}
