package com.pavani.benchmark.controller;

import com.pavani.benchmark.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @PostMapping
    private ResponseEntity<HttpStatus> upload(@RequestBody String filePath) {
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            uploadService.loadExcelToDB(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = HttpStatus.FAILED_DEPENDENCY;
        }
        return new ResponseEntity<>(httpStatus);
    }
}
