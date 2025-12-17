package com.tweiy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweiy.pojo.Clazz;
import com.tweiy.pojo.ClazzPageQueryParam;
import com.tweiy.pojo.PageResult;
import com.tweiy.pojo.Result;
import com.tweiy.service.ClazzService;

import lombok.extern.slf4j.Slf4j;

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
     * 新增班级
     */
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("新增班级： {}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }
}
