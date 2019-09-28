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
import java.util.List;

@Repository
public class TodayCommitDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<TodayCommit> rowMapper = BeanPropertyRowMapper.newInstance(TodayCommit.class);

    public TodayCommitDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("chkCommit").usingGeneratedKeyColumns("id");
    }

    public Long insertTodayCommit(TodayCommit todayCommit){
        SqlParameterSource params = new BeanPropertySqlParameterSource(todayCommit);
        return insertAction.executeAndReturnKey(params).longValue();
    }

    public List<TodayCommit> selectAllTodayCommit(){
        return jdbc.query()
    }

}
