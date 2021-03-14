package com.pavani.benchmark.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "perfresults")
@Data
@Builder
public class PerfResults {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "TestId")
    private String testId;
    @Column(name = "KPI_LABEL")
    private String label;
    @Column(name = "BKC")
    private String milestone;
    @ToString.Exclude
    @Column(name = "FIP")
    private String fip;
    @Column(name = "WW")
    private String workWeek;
    @ToString.Exclude
    @Column(name = "EVM_ID")
    private String boardId;
    @Column(name = "Device")
    private String boardName;
    @Column(name = "Model_Name")
    private String model;
    @Column(name = "Num_Iterations")
    private String iterations;
    @Column(name = "Slice")
    private String slice;
    @Column(name = "E2E_Throughput")
    private String throughput;
    @Column(name = "Inference_Latency")
    private String latency;
    @Column(name = "CPU_Utilization")
    private String cpuUtil;
    @Column(name = "Memory_Sys_Avg")
    private String avgMem;
    @Column(name = "Memory_Sys_Peak")
    private String peakMem;
    @Column(name = "Memory_Idle")
    private String idleMem;
    @Column(name = "Memory_Application")
    private String appMem;
    @Column(name = "Command")
    private String cmd;
}
