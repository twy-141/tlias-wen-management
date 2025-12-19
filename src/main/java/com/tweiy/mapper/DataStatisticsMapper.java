package com.tweiy.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataStatisticsMapper {
    /**
     * 班级人数统计
     */
    @MapKey("class_name")
    List<Map<String, Object>> countClassStudent();

     /**
      * 学员学历统计
      */
    @MapKey("education")
    List<Map<String, Object>> countStudentEducation();
}
