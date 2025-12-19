package com.tweiy.dto.student;

import lombok.Data;

@Data
public class StudentPageQueryDTO {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name; // 姓名
    private Integer clazzId; // 班级ID
    private Integer degree; // 学历
}
