package com.likelion.dao;

import com.likelion.domain.LverDgThnf;
import com.likelion.mapper.LverDgThnfRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class LverDgThnfDao {
    private JdbcTemplate jdbcTemplate;

    RowMapper<LverDgThnf> rowMapper = new LverDgThnfRowMapper();

    public LverDgThnfDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<LverDgThnf> findAll() {
        return this.jdbcTemplate.query("select * from LVER_DG_THNF",
                rowMapper);
    }
}
