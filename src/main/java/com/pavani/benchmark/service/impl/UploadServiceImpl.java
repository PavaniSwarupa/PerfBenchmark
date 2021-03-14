package com.pavani.benchmark.service.impl;

import com.pavani.benchmark.model.PerfResults;
import com.pavani.benchmark.repository.PerfResultsRepository;
import com.pavani.benchmark.service.UploadService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private PerfResultsRepository perfResultsRepository;

    @Override
    public boolean loadExcelToDB(String filePath) throws Exception {
        return readExcelAndSaveToDB(filePath);
    }

    private Boolean readExcelAndSaveToDB(String filePath) throws Exception {
        System.out.println("File Path ::::::::::"+new File("").getAbsolutePath());
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("File exists");
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet("Latest KPI Entry");
            PerfResults perfResults = null;
            for (Row currentRow : sheet) {
                perfResults = mapToModel(currentRow);
                perfResultsRepository.save(perfResults);
            }
            workbook.close();
        } else
            throw new FileNotFoundException("File not found");
        return Boolean.TRUE;
    }

    private PerfResults mapToModel(Row currentRow) {
        return PerfResults.builder()
                .testId(currentRow.getCell(0).toString())
                .label(currentRow.getCell(1).toString())
                .milestone(currentRow.getCell(2).toString())
                .fip(currentRow.getCell(3).toString())
                .workWeek(currentRow.getCell(4).toString())
                .boardId(currentRow.getCell(5).toString())
                .boardName(currentRow.getCell(6).toString())
                .model(currentRow.getCell(7).toString())
                .iterations(currentRow.getCell(8).toString())
                .slice(currentRow.getCell(9).toString())
                .throughput(currentRow.getCell(10).toString())
                .latency(currentRow.getCell(11).toString())
                .cpuUtil(currentRow.getCell(12).toString())
                .avgMem(currentRow.getCell(13).toString())
                .peakMem(currentRow.getCell(14).toString())
                .idleMem(currentRow.getCell(15).toString())
                .appMem(currentRow.getCell(16).toString())
                .cmd(currentRow.getCell(17).toString())
                .build();
    }

}
