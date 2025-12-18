package com.tweiy.service;

import com.tweiy.dto.StudentPageQueryDTO;
import com.tweiy.pojo.PageResult;
import com.tweiy.pojo.Student;

public interface StudentService {
    /**
     * 分页查询学生
     */
    PageResult findPage(StudentPageQueryDTO studentPageQueryDTO);

    /**
     * 新增学员
     */
    void add(Student student);

    /**
     * 根据id查询学员信息
     */
    Student findById(Integer id);
}
