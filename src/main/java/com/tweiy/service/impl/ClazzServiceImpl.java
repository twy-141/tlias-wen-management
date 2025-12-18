package com.tweiy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tweiy.mapper.ClazzMapper;
import com.tweiy.mapper.StudentMapper;
import com.tweiy.pojo.Clazz;
import com.tweiy.pojo.ClazzPageQueryParam;
import com.tweiy.pojo.PageResult;
import com.tweiy.service.ClazzService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StudentMapper studentMapper;

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
    /**
     * 查询所有班级
     */
    @Override
    public List<Clazz> list() {
        return clazzMapper.listAll();
    }

    /**
     * 新增班级
     */
    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    /**
     * 根据ID查询班级
     */
    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据ID修改班级信息
     */
    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateByPrimaryKey(clazz);
    }

    /**
     * 根据ID删除班级
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        // 1. 校验班级下是否有学生
        int count = studentMapper.countByClazzId(id);
        if (count > 0) {
            throw new IllegalArgumentException("班级下有学生，不能删除");
        }

        // 2. 删除班级
        clazzMapper.deleteByPrimaryKey(id);
    }
}
