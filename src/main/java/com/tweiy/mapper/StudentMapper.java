package com.tweiy.mapper;

import com.tweiy.dto.student.StudentPageQueryDTO;
import com.tweiy.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    /**
     * 分页查询学生
     */
    public List<Student> list(StudentPageQueryDTO studentPageQueryDTO);

    /**
     * 根据班级id查询有多少学生
     */
    @Select("select count(*) from student where clazz_id = #{clazzId}")
    int countByClazzId(Integer clazzId);

    /**
     * 新增学员
     */
    @Insert("insert into student(name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time) " +
            "values(#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId}, #{violationCount}, #{violationScore}, #{createTime}, #{updateTime})")
    void insert(Student student);

    /**
     * 根据id查询学员信息
     */
    @Select("select s.*, c.name as clazz_name from student as s left join clazz as c on s.clazz_id = c.id where s.id = #{id}")
    Student findById(Integer id);

     /**
      * 修改学员信息
      */
    void updateByPrimaryKey(Student student);

    /**
     * 批量删除学员
     */
    void deleteBatch(List<Integer> ids);
}
