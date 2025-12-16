package com.tweiy.pojo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpQueryParam {

    private Integer page = 1;
    private Integer pageSize = 10;
    private String name; // 姓名
    private Integer gender; // 性别
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; // 开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; // 结束时间
}
