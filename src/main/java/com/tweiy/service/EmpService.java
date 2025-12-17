package com.tweiy.service;

import java.util.List;

import com.tweiy.pojo.Emp;
import com.tweiy.pojo.EmpQueryParam;
import com.tweiy.pojo.PageResult;

public interface EmpService {
    /**
     * 分页查询员工信息
     */
    public PageResult findPage(EmpQueryParam empQueryParam);

    /**
     * 根据ID查询员工
     */
    public Emp getById(Integer id);

    /**
     * 新增员工
     */
    public void save(Emp emp);

    /**
     * 批量删除员工
     */
    public void deleteBatch(List<Integer> ids);

    /**
     * 更新员工信息
     */
    public void update(Emp emp);
}
