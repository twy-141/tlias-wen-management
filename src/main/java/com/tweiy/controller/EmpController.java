package com.tweiy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweiy.pojo.Emp;
import com.tweiy.pojo.EmpQueryParam;
import com.tweiy.pojo.PageResult;
import com.tweiy.pojo.Result;
import com.tweiy.service.EmpService;

import lombok.extern.slf4j.Slf4j;

/**
 * 员工管理
 */

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 查询员工基本信息及部门名称
     */
    @GetMapping
    public Result list(EmpQueryParam empQueryParam) {
        log.info("查询请求参数： {}", empQueryParam);
        PageResult pageResult = empService.findPage(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 根据ID查询员工
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据ID查询员工： {}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    /**
     * 新增员工
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工： {}", emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * 批量删除员工
     */
    @DeleteMapping
    public Result deleteBatch(@RequestParam List<Integer> ids) {
        log.info("批量删除员工： {}", ids);
        empService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 更新员工信息
     */
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("更新员工信息： {}", emp);
        empService.update(emp);
        return Result.success();
    }
}
