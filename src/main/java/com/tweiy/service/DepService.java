package com.tweiy.service;

import java.util.List;

import com.tweiy.pojo.Dept;

public interface DepService {
    /**
     * 查询所有部门
     */
    public List<Dept> findAll();

    /**
     * 根据id删除部门
     */
    public Integer deleteById(Integer id);

    /**
     * 新增部门
     */
    public void add(Dept dept);

    /**
     * 根据id查询部门
     */
    public Dept getById(Integer id);

    /**
     * 修改部门
     */
    public Integer update(Dept dept);
}
