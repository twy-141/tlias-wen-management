package com.tweiy.service.impl;

import com.tweiy.mapper.EmpLogMapper;
import com.tweiy.pojo.EmpLog;
import com.tweiy.service.EmpLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 员工操作日志服务实现类
 */
@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    /**
     * 新增员工操作日志
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW) // 开启新事务 独立事物不会受到影响除非内部错误发生
    @Override
    public void insert(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }

}
