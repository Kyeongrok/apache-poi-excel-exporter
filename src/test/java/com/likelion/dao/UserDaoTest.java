package com.likelion.dao;

import com.likelion.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void addAndGet() {
        UserDao userDao = new UserDaoFactory().awsUserDao();
        String id = "44";
        userDao.add(new User(id, "kyeongrok", "12345"));
        User user = userDao.findById(id);
        assertEquals("kyeongrok", user.getName());
        assertEquals("12345", user.getPassword());
    }
}