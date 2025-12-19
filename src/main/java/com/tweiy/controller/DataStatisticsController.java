package com.tweiy.controller;

import com.tweiy.pojo.Result;
import com.tweiy.pojo.StatisticsOption;
import com.tweiy.service.DataStatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/statistics")
public class DataStatisticsController {

    @Autowired
    private DataStatisticsService dataStatisticsService;

    /**
     * 班级人数统计
     */
    @RequestMapping("/class")
    public Result countClassStudent() {
        StatisticsOption statisticsOption = dataStatisticsService.countClassStudent();
        return Result.success(statisticsOption);
    }

    /**
     * 学员学历统计
     */
    @RequestMapping("/education")
    public Result countStudentEducation() {
        StatisticsOption statisticsOption = dataStatisticsService.countStudentEducation();
        return Result.success(statisticsOption);
    }
}
