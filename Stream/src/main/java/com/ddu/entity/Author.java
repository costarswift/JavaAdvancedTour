package com.ddu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author Costar
 * @Date 周六 2024/2/24 13:29
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode //去重
public class Author implements Comparable{
    //id
    private Long id;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //简介
    private String intro;
    //作品
    private List<Book> books;

    @Override
    public int compareTo(Object o) {
        if (o instanceof Author) {
            return ((Author) o).getAge() - this.age;
        }
        throw new ClassCastException();
    }
}
