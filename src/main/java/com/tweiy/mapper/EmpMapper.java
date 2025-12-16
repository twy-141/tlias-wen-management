package com.tweiy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.tweiy.pojo.Emp;
import com.tweiy.pojo.EmpQueryParam;

@Mapper
public interface EmpMapper {

    /**
     * 查询员工基本信息及部门名称
     */
    public List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 根据ID查询员工详细信息
     */
    public Emp getById(Integer id);

    /**
     * 新增员工
     */
    @Options(useGeneratedKeys = true, keyProperty = "id") // 开启主键返回，将返回的主键值设置到emp对象的id属性中
    @Insert("insert into emp (username, password, name, gender, phone, image, job, salary, entry_date, dept_id, create_time, update_time) " +
            "values (#{username}, #{password}, #{name}, #{gender}, #{phone}, #{image}, #{job}, #{salary}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);
}
