package com.tweiy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tweiy.pojo.EmpExpr;

@Mapper
public interface EmpExprMapper {

    /**
     * 批量插入员工工作经历信息
     */
    void insertBatch(List<EmpExpr> exprList);

    /**
     * 批量删除员工工作经历信息
     */
    void deleteBatch(List<Integer> ids);
}
