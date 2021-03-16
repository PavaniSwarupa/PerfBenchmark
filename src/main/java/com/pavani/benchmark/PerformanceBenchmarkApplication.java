package com.pavani.benchmark;

import com.pavani.benchmark.service.UploadService;
import com.pavani.benchmark.service.impl.UploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class PerformanceBenchmarkApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerformanceBenchmarkApplication.class, args);
	}

}
