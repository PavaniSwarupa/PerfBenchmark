package com.pavani.benchmark.service.impl;

import com.pavani.benchmark.service.UploadService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;

public class UploadServiceImpl implements UploadService {
    @Override
    public boolean loadExcelToDB(String filePath) throws Exception {
        readExcel(filePath);
        return Boolean.TRUE;
    }

    private void readExcel(String filePath) throws Exception {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("File exists");
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet("Latest KPI Entry");
            for (Row currentRow : sheet) {
                for (Cell currentCell : currentRow) {
                    System.out.print(currentCell + " ");
                }
                System.out.println("");
            }
            //workbook.close();
        } else
            throw new FileNotFoundException("File not found");
    }
}
