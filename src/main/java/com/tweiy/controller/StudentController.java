package com.tweiy.controller;

import com.tweiy.dto.StudentPageQueryDTO;
import com.tweiy.pojo.PageResult;
import com.tweiy.pojo.Result;
import com.tweiy.pojo.Student;
import com.tweiy.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 分页查询学生
     */
    @GetMapping
    public Result getStudentPage(StudentPageQueryDTO studentPageQueryDTO) {
        log.info("查询班级分页信息: {}", studentPageQueryDTO);
        PageResult pageResult = studentService.findPage(studentPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 新增学员
     */
    @PostMapping
    public Result addStudent(@RequestBody Student student) {
        log.info("新增学员: {}", student);
        studentService.add(student);
        return Result.success();
    }

    /**
     * 根据id查询学员信息
     */
    @GetMapping("/{id}")
    public Result getStudentById(@PathVariable Integer id) {
        log.info("根据id查询学员信息: {}", id);
        Student student = studentService.findById(id);
        return Result.success(student);
    }
}
