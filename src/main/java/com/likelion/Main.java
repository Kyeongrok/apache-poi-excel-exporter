package com.likelion;

import com.likelion.dao.LverDgThnfDao;
import com.likelion.dao.LverDgThnfDaoFactory;
import com.likelion.domain.LverDgThnf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(LverDgThnfDaoFactory.class, args);

        // ApplicationContext에서 빈을 가져와 사용
        LverDgThnfDao dao = applicationContext.getBean(LverDgThnfDao.class);
        List<LverDgThnf> l = dao.findAll();
        System.out.println(l.size());

    }
}
