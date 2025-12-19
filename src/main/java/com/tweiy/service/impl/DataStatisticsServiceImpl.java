package com.tweiy.service.impl;

import com.tweiy.mapper.DataStatisticsMapper;
import com.tweiy.pojo.StatisticsOption;
import com.tweiy.service.DataStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DataStatisticsServiceImpl implements DataStatisticsService {

    @Autowired
    private DataStatisticsMapper dataStatisticsMapper;

    /**
     * 班级人数统计
     */
    @Override
    public StatisticsOption countClassStudent() {
        List<Map<String, Object>> list = dataStatisticsMapper.countClassStudent();
        List<Object> classList = list.stream().map(dataMap -> dataMap.get("class_name")).toList();
        List<Object> studentCountList = list.stream().map(dataMap -> dataMap.get("student_count")).toList();
        return new StatisticsOption(classList, studentCountList);
    }

    /**
     * 学员学历统计
     */
    @Override
    public StatisticsOption countStudentEducation() {
        List<Map<String, Object>> list = dataStatisticsMapper.countStudentEducation();
        List<Object> educationList = list.stream().map(dataMap -> dataMap.get("education")).toList();
        List<Object> studentCountList = list.stream().map(dataMap -> dataMap.get("student_count")).toList();
        return new StatisticsOption(educationList, studentCountList);
    }
}
