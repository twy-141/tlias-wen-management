package com.tweiy.service;

import com.tweiy.pojo.EmpLog;


public interface EmpLogService {

    /**
     * 新增员工操作日志
     */
    public void insert(EmpLog empLog);
}
