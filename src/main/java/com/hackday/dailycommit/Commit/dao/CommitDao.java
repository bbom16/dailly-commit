package com.hackday.dailycommit.Commit.dao;

import com.hackday.dailycommit.Commit.dto.Commit;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CommitDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Commit> commitRowMapper = BeanPropertyRowMapper.newInstance(Commit.class);

    public CommitDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("commitInfo")
                .usingGeneratedKeyColumns("id");
    }

    public Long insertCommit(Commit commit){
        SqlParameterSource params = new BeanPropertySqlParameterSource(commit);
        return insertAction.executeAndReturnKey(params).longValue();
    }

}
