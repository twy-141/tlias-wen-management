package com.tweiy.service;

import com.tweiy.pojo.Clazz;
import com.tweiy.pojo.ClazzPageQueryParam;
import com.tweiy.pojo.PageResult;

public interface ClazzService {
    /**
     * 分页查询班级列表
     */
    PageResult findPage(ClazzPageQueryParam clazzPageQueryParam);

    /**
     * 新增班级
     */
    public void save(Clazz clazz);
}
