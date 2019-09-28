package com.hackday.dailycommit.User.dao;

import com.hackday.dailycommit.User.dto.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collections;
import java.util.List;

import static com.hackday.dailycommit.User.dao.UserDaoSqls.*;

@Repository
public class UserDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<User> userRowMapper = BeanPropertyRowMapper.newInstance(User.class);

    public UserDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("userInfo")
                .usingGeneratedKeyColumns("id");

    }

    public List<User> selectUserList(){
        return jdbc.query(SELECT_ALL_USERS, Collections.emptyMap(), userRowMapper);
    }

    public Long insertUser(User newUser){
        SqlParameterSource params = new BeanPropertySqlParameterSource(newUser);
        try {
            return insertAction.executeAndReturnKey(params).longValue();
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            return null;
        }
    }
}
