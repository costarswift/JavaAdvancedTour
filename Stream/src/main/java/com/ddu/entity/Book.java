package com.ddu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author Costar
 * @Date 周六 2024/2/24 13:41
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode //去重
public class Book {
    //id
    private Long id;
    //书名
    private String name;

    //分类
    private String category;

    //评分
    private Integer score;

    //简介
    private String intro;
}
