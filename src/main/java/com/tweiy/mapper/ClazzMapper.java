package com.tweiy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tweiy.pojo.Clazz;
import com.tweiy.pojo.ClazzPageQueryParam;

@Mapper
public interface ClazzMapper {
    /**
     * 分页查询班级列表
     */
    public List<Clazz> list(ClazzPageQueryParam clazzPageQueryParam);
}
