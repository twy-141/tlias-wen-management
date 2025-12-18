package com.tweiy.service;

import com.tweiy.pojo.Clazz;
import com.tweiy.pojo.ClazzPageQueryParam;
import com.tweiy.pojo.PageResult;
import java.util.List;

public interface ClazzService {
    /**
     * 分页查询班级列表
     */
    public PageResult findPage(ClazzPageQueryParam clazzPageQueryParam);

     /**
     * 查询所有班级
     */
    public List<Clazz> list();

    /**
     * 新增班级
     */
    public void save(Clazz clazz);

    /**
     * 根据ID查询班级
     */
    public Clazz getById(Integer id);

     /**
     * 根据ID修改班级信息
     */
    public void update(Clazz clazz);

    /**
     * 根据ID删除班级
     */
    public void delete(Integer id);
}
