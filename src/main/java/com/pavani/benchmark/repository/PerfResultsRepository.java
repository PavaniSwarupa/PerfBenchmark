package com.pavani.benchmark.repository;

import com.pavani.benchmark.model.PerfResults;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfResultsRepository extends JpaRepository<PerfResults, Long> {
}
