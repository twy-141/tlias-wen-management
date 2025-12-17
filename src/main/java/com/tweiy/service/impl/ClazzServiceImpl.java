package com.tweiy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tweiy.mapper.ClazzMapper;
import com.tweiy.pojo.Clazz;
import com.tweiy.pojo.ClazzPageQueryParam;
import com.tweiy.pojo.Emp;
import com.tweiy.pojo.PageResult;
import com.tweiy.service.ClazzService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    /**
     * 分页查询班级列表
     */
    @Override
    public PageResult findPage(ClazzPageQueryParam clazzPageQueryParam) {
        // 1. 设置分页参数
        PageHelper.startPage(clazzPageQueryParam.getPage(), clazzPageQueryParam.getPageSize());

        // 2. 执行查询
        List<Clazz> clazzList = clazzMapper.list(clazzPageQueryParam);

        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult(p.getTotal(), p.getResult());
    }

}
