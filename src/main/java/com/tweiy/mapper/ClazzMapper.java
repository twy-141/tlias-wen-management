package com.tweiy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.tweiy.pojo.Clazz;
import com.tweiy.pojo.ClazzPageQueryParam;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClazzMapper {
    /**
     * 分页查询班级列表
     */
    public List<Clazz> list(ClazzPageQueryParam clazzPageQueryParam);
    /**
     * 查询所有班级
     */
    @Select("select * from clazz")
    public List<Clazz> listAll();

    /**
     * 新增班级
     */
    @Insert("insert into clazz (name,room, begin_date, end_date, master_id,subject,create_time,update_time) values (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId},#{subject},#{createTime},#{updateTime})")
    public void insert(Clazz clazz);

    /**
     * 根据ID查询班级
     */
    public Clazz selectByPrimaryKey(Integer id);

    /**
     * 根据ID修改班级信息
     */
    public void updateByPrimaryKey(Clazz clazz);

    /**
     * 根据ID删除班级
     */
    @Delete("delete from clazz where id = #{id}")
    public void deleteByPrimaryKey(Integer id);
}
