package com.tweiy.service;

import java.util.List;
import java.util.Map;

import com.tweiy.pojo.JobOption;

public interface ReportService {
    /**
     * 统计各个职位的员工人数
     */
    JobOption getEmpJobData();

    /**
     * 统计员工性别信息
     */
    List<Map> getEmpGenderData();
}
