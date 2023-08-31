package com.likelion;

import com.likelion.dao.LverDgThnfDao;
import com.likelion.dao.LverDgThnfDaoFactory;
import com.likelion.domain.LverDgThnf;
import com.likelion.exporter.ExcelExporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = SpringApplication.run(LverDgThnfDaoFactory.class, args);

        // ApplicationContext에서 빈을 가져와 사용
        LverDgThnfDao dao = applicationContext.getBean(LverDgThnfDao.class);

        // db에서 select
        List<LverDgThnf> l = dao.findAll();
        System.out.printf("선택된 건수는 %d건 입니다.\n", l.size());

        // 엑셀로 저장
        ExcelExporter exporter = new ExcelExporter();
        String excelFileName = "output.xlsx"; // 저장될 파일명
        exporter.exportToExcel(l, excelFileName);
    }
}
