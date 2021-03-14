package com.pavani.benchmark.controller;

import com.pavani.benchmark.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @PostMapping
    public HttpStatus upload(@RequestBody String filePath) {
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            System.out.println("In Upload Controller FilePath " + filePath);
            uploadService.loadExcelToDB(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = HttpStatus.FAILED_DEPENDENCY;
        }
        return httpStatus;
    }

    @GetMapping
    public String getData() {
        return "Not Implemented Yet";
    }

}
