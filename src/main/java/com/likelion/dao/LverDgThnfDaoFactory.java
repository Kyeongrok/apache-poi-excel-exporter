package com.likelion.dao;

import com.likelion.properties.DataSourceProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class LverDgThnfDaoFactory {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Bean
    public LverDgThnfDao awsUserDao() {
        return new LverDgThnfDao(propertyDataSource());
    }


    public DataSource propertyDataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    public DataSource awsDataSource() {
        Map<String, String> env = System.getenv();
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl(env.get("DB_HOST"));
        dataSource.setUsername(env.get("DB_USER"));
        dataSource.setPassword(env.get("DB_PASSWORD"));
        return dataSource;
    }

}
