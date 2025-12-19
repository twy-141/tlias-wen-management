package com.tweiy.service;

import com.tweiy.dto.student.DisciplineDTO;
import com.tweiy.dto.student.StudentPageQueryDTO;
import com.tweiy.pojo.PageResult;
import com.tweiy.pojo.Student;

import java.util.List;

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

    /**
     * 修改学员信息
     */
    void update(Student student);

    /**
     * 批量删除学员
     */
    void deleteBatch(List<Integer> ids);

     /**
      * 违纪处理
      */
    void discipline(DisciplineDTO disciplineDTO);
}
