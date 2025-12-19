package com.tweiy.controller;

import com.tweiy.dto.student.DisciplineDTO;
import com.tweiy.dto.student.StudentPageQueryDTO;
import com.tweiy.pojo.PageResult;
import com.tweiy.pojo.Result;
import com.tweiy.pojo.Student;
import com.tweiy.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 修改学员信息
     */
    @PutMapping
    public Result updateStudent(@RequestBody Student student) {
        log.info("修改学员信息: {}", student);
        studentService.update(student);
        return Result.success();
    }

    /**
     * 批量删除学员
     */
    @DeleteMapping
    public Result deleteStudents(@RequestParam List<Integer> ids) {
        log.info("批量删除学员: {}", ids);
        studentService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 违纪处理
     */
    @PostMapping("/discipline")
    public Result disciplineStudent(@RequestBody DisciplineDTO disciplineDTO) {
        log.info("违纪处理: {}", disciplineDTO);
        try {
            studentService.discipline(disciplineDTO);
        } catch (Exception e) {
            log.error("违纪处理失败: {}", disciplineDTO);
            return Result.error(e.getMessage());
        }
        return Result.success();
    }
}
