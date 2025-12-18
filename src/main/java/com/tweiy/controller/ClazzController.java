package com.tweiy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tweiy.pojo.Clazz;
import com.tweiy.pojo.ClazzPageQueryParam;
import com.tweiy.pojo.PageResult;
import com.tweiy.pojo.Result;
import com.tweiy.service.ClazzService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazz")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 分页查询班级列表
     */
    @GetMapping
    public Result getClazzPage(ClazzPageQueryParam clazzPageQueryParam) {
        log.info("分页查询班级列表, 参数: {}", clazzPageQueryParam);
        PageResult pageResult = clazzService.findPage(clazzPageQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 查询所有班级
     */
    @GetMapping("/list")
    public Result getClazzList() {
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.list();
        return Result.success(clazzList);
    }

    /**
     * 新增班级
     */
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("新增班级： {}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    /**
     * 根据ID查询班级
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据ID查询班级： {}", id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    /**
     * 修改班级信息
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("根据ID修改班级信息： {}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    /**
     * 根据ID删除班级
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据ID删除班级： {}", id);
        try {
            clazzService.delete(id);
        } catch (Exception e) {
            log.error("根据ID删除班级失败： {}", id, e);
            return Result.error(e.getMessage());
        }
        return Result.success();
    }
}
