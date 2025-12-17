package com.tweiy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.tweiy.pojo.Clazz;
import com.tweiy.pojo.ClazzPageQueryParam;

@Mapper
public interface ClazzMapper {
    /**
     * 分页查询班级列表
     */
    public List<Clazz> list(ClazzPageQueryParam clazzPageQueryParam);

    /**
     * 新增班级
     */
    @Insert("insert into clazz (name,room, begin_date, end_date, master_id,subject,create_time,update_time) values (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId},#{subject},#{createTime},#{updateTime})")
    public void insert(Clazz clazz);

    /**
     * 根据ID查询班级
     */
    public Clazz selectByPrimaryKey(Integer id);
}
