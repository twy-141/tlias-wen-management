package com.tweiy.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.tweiy.pojo.EmpLog;

@Mapper
public interface EmpLogMapper {
    /**
     * 新增员工操作日志
     */
    @Insert("insert into emp_log(operate_time, info) values(#{operateTime}, #{info})")
    public void insert(EmpLog empLog);
}
