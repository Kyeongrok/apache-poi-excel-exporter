package com.likelion.exporter;

import com.likelion.domain.LverDgThnf;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {
    public void exportToExcel(List<LverDgThnf> dataList, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("LVER_DG_THNF");

        int rowNum = 0;
        for (LverDgThnf data : dataList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(data.getId());
            row.createCell(1).setCellValue(data.getCenterCd());
            row.createCell(2).setCellValue(data.getIrbAprvNo());
            row.createCell(3).setCellValue(data.getPtSbstNo());
            row.createCell(4).setCellValue(data.getAndgAnthRcrdYmd());
            row.createCell(5).setCellValue(data.getAndgAnthSeq());
            row.createCell(6).setCellValue(data.getAndgHtMsrmYmd());
            row.createCell(7).setCellValue(data.getAndgHtMsrmVl());
            row.createCell(8).setCellValue(data.getAndgBmiVl());
            row.createCell(9).setCellValue(data.getAndgEcogCd());
            row.createCell(10).setCellValue(data.getAndgEcogNm());
            row.createCell(11).setCellValue(data.getAndgEcogCdEtcCont());
            row.createCell(12).setCellValue(data.getAndgCtrtBlprVl());
            row.createCell(13).setCellValue(data.getAndgRlxtBlprVl());
            row.createCell(14).setCellValue(data.getCrtnDt());

        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }

        workbook.close();
    }
}
