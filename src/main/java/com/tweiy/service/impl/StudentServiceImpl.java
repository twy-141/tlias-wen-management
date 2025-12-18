package com.tweiy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tweiy.dto.StudentPageQueryDTO;
import com.tweiy.mapper.StudentMapper;
import com.tweiy.pojo.PageResult;
import com.tweiy.pojo.Student;
import com.tweiy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 分页查询学生
     */
    @Override
    public PageResult findPage(StudentPageQueryDTO studentPageQueryDTO) {
        // 分页查询
        PageHelper.startPage(studentPageQueryDTO.getPage(), studentPageQueryDTO.getPageSize());
        List<Student> studentList = studentMapper.list(studentPageQueryDTO);
        // 分页信息
        Page<Student> p = (Page<Student>) studentList;
        return new PageResult(p.getTotal(), p.getResult());
    }

    /**
     * 新增学员
     */
    @Override
    public void add(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        student.setViolationCount((short) 0);
        student.setViolationScore((short) 0);

        studentMapper.insert(student);
    }

    /**
     * 根据id查询学员信息
     */
    @Override
    public Student findById(Integer id) {
        return studentMapper.findById(id);
    }
}
