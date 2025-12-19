package com.tweiy.service.impl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.tweiy.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tweiy.mapper.EmpExprMapper;
import com.tweiy.mapper.EmpMapper;
import com.tweiy.service.EmpLogService;
import com.tweiy.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;

    /**
     * 查询员工基本信息及部门名称
     */
    @Override
    public PageResult findPage(EmpQueryParam empQueryParam) {
        // 1. 设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        // 2. 执行查询
        List<Emp> empList = empMapper.list(empQueryParam);
        Page<Emp> p = (Page<Emp>) empList;

        // 3. 封装结果
        return new PageResult(p.getTotal(), p.getResult());
    }

    /**
     * 查询所有员工
     */
    @Override
    public List<EmpSimple> listAll() {
        return empMapper.listAll();
    }

    /**
     * 根据ID查询员工
     */
    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    /**
     * 新增员工
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(Emp emp) {
        try {
            /**
             * 补全基础属性
             */
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());

            /**
             * 新增员工基本信息
             */
            empMapper.insert(emp);

            /**
             * 新增员工工作经历信息
             */
            Integer empId = emp.getId();
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                exprList.forEach(empExpr -> empExpr.setEmpId(empId));
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            /**
             * 新增员工操作日志
             */
            EmpLog empLog = new EmpLog();
            empLog.setOperateTime(LocalDateTime.now());
            empLog.setInfo("新增员工：" + emp.getName());
            empLogService.insert(empLog);
        }
    }

    /**
     * 批量删除员工
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteBatch(List<Integer> ids) {
        empMapper.deleteBatch(ids);
        empExprMapper.deleteBatch(ids);
    }

    /**
     * 更新员工信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) {
        try {
            /**
             * 补全基础属性
             */
            emp.setUpdateTime(LocalDateTime.now());

            /**
             * 更新员工基本信息
             */
            empMapper.update(emp);

            /**
             * 更新员工工作经历信息
             */
            Integer empId = emp.getId();
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                exprList.forEach(empExpr -> empExpr.setEmpId(empId));
                empExprMapper.deleteBatch(Arrays.asList(emp.getId()));
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            /**
             * 更新员工操作日志
             */
            EmpLog empLog = new EmpLog();
            empLog.setOperateTime(LocalDateTime.now());
            empLog.setInfo("更新员工：" + emp.getName());
            empLogService.insert(empLog);
        }
    }

    /**
     * 登录
     */
    @Override
    public LoginInfo login(Emp emp) {
        Emp empLogin = empMapper.getUsernameAndPassword(emp);
        if (empLogin != null) {
            LoginInfo loginInfo = new LoginInfo(empLogin.getId(), empLogin.getUsername(), empLogin.getName(), null);
            return loginInfo;
        }
        return null;
    }
}
