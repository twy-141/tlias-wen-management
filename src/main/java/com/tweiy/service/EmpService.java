package com.tweiy.service;

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
}
