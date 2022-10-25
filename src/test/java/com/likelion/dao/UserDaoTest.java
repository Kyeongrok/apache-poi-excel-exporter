package com.likelion.dao;

import com.likelion.domain.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {

    @Autowired
    ApplicationContext context;
    UserDao userDao;
    User user1;
    User user2;
    User user3;


    @BeforeEach
    void setUp() {
        this.userDao = context.getBean("awsUserDao", UserDao.class);
        this.user1 = new User("0", "kyeongrok", "12345");
        this.user2 = new User("1", "eternityHwan", "54321");
        this.user3 = new User("2", "jiyu", "abcde");
    }

    @Test
    void addAndGet() throws SQLException {
        userDao.deleteAll();
        assertEquals(0, userDao.getCount());
        userDao.add(user1);
        User user = userDao.findById(user1.getId());
        assertEquals(user1.getName(), user.getName());
        assertEquals(user1.getPassword(), user.getPassword());
    }

    @Test
    @DisplayName("findById에서 해당 user를 못 찾은 경우 Exception이 잘 발생 하는지")
    void emptyResultException() throws SQLException {
        userDao.deleteAll();
        assertThrows(EmptyResultDataAccessException.class, () -> userDao.findById("0"));
    }

    @Test
    @DisplayName("findAll이 잘 작동 하는지")
    void findAll() {
        userDao.deleteAll();
        assertEquals(0, userDao.findAll().size());
        userDao.add(user1);
        userDao.add(user2);
        userDao.add(user3);
        assertEquals(3, userDao.findAll().size());

    }
}