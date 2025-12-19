package com.tweiy.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.tweiy.pojo.Emp;
import com.tweiy.pojo.EmpQueryParam;
import com.tweiy.pojo.EmpSimple;

@Mapper
public interface EmpMapper {
    /**
     * 查询所有员工
     */
    @Select("select id,name from emp")
    public List<EmpSimple> listAll();

    /**
     * 统计员工性别信息
     */
    @MapKey("name")
    List<Map> countEmpGenderData();

    /**
     * 统计每个岗位的员工数量
     */
    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();
        
    /**
     * 更新员工信息
     */
    void update(Emp emp);

    /**
     * 批量删除员工
     */
    void deleteBatch(List<Integer> ids);

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

     /**
     * 根据用户名和密码查询员工
     */
    @Select("select id,username,password,name from emp where username=#{username} and password=#{password}")
    public Emp getUsernameAndPassword(Emp emp);
}
