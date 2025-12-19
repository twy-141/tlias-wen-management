package com.tweiy.service;

import com.tweiy.pojo.StatisticsOption;

public interface DataStatisticsService {

    /**
     * 班级人数统计
     */
    StatisticsOption countClassStudent();

    /**
     * 学员学历统计
     */
    StatisticsOption countStudentEducation();
}
