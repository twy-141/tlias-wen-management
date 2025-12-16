package com.tweiy.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {
    private Long total; // 总记录数
    private List rows; // 当前页数据列表
}
