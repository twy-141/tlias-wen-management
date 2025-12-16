package com.tweiy.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweiy.mapper.DepMapper;
import com.tweiy.pojo.Dept;
import com.tweiy.service.DepService;

@Service
public class DepServiceImpl implements DepService {

    @Autowired
    private DepMapper depMapper;

    /**
     * 查询所有部门
     */
    @Override
    public List<Dept> findAll() {
        return depMapper.findAll();
    }

    /**
     * 根据id删除部门
     */
    @Override
    public Integer deleteById(Integer id) {
        return depMapper.deleteById(id);
    }

    /**
     * 新增部门
     */
    @Override
    public void add(Dept dept) {
        // 新增部门时, 手动设置创建时间和更新时间
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        depMapper.insert(dept);
    }

    /**
     * 根据id查询部门
     */
    @Override
    public Dept getById(Integer id) {
        return depMapper.selectById(id);
    }

    /**
     * 修改部门
     */
    @Override
    public Integer update(Dept dept) {
        // 修改部门时, 手动设置更新时间
        dept.setUpdateTime(LocalDateTime.now());
        return depMapper.update(dept);
    }
}
