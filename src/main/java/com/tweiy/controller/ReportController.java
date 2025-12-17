package com.tweiy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweiy.pojo.JobOption;
import com.tweiy.pojo.Result;
import com.tweiy.service.ReportService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 统计各个职位的员工人数
     */
    @GetMapping("/empJobData")
    public Result getEmpJobCount() {
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 统计员工性别信息
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderCount() {
        List<Map> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }
}
