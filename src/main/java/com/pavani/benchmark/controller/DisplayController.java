package com.pavani.benchmark.controller;

import com.pavani.benchmark.dto.FilterDTO;
import com.pavani.benchmark.service.DisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/display")
public class DisplayController {

    @Autowired
    DisplayService displayService;

    @GetMapping
    public void getPerfResults() {
        displayService.getPerfResults(new FilterDTO());
    }
}
