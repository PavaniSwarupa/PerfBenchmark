package com.pavani.benchmark.dto;

import lombok.Data;

@Data
public class FilterDTO {
    private String testId;
    private String milestone;
    private String model;
    private String slice;
}
