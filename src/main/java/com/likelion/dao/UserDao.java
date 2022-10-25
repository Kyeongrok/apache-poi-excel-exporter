package com.likelion.dao;

import com.likelion.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    RowMapper<User> rowMapper = (rs, rowNum) ->  new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));

    public void deleteAll() {
        this.jdbcTemplate.update("delete from users");
    }

    public int getCount() {
        return this.jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
    }

    public void add(User user) {
        this.jdbcTemplate.update("INSERT INTO users(id, name, password) VALUES(?,?,?);",
                user.getId(), user.getName(), user.getPassword());
    }

    public User findById(String id) {
        return this.jdbcTemplate.queryForObject("select * from users where id = ?",
                rowMapper, id);
    }

    public List<User> findAll() {
        return this.jdbcTemplate.query("select * from users",
                rowMapper);
    }

}
