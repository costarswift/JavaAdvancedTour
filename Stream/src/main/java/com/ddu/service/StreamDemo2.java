package com.ddu.service;

import com.ddu.entity.Author;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.ddu.service.StreamDemo.getAuthors;

/**
 * @Author Costar
 * @Date 周六 2024/2/24 14:26
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        // 创建流

        // 单列集合： `集合对象.stream()`
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        // 数组：`Arrays.stream(数组) `或者使用`Stream.of`来创建
        Integer[] arr = {1,2,3,4,5};
        Stream<Integer> stream1 = Arrays.stream(arr);
        Stream<Integer> stream2 = Stream.of(arr);

        // 双列集合：转换成单列集合后再创建
        Map<String,Integer> map = new HashMap<>();
        map.put("蜡笔小新",19);
        map.put("黑子",17);
        map.put("日向翔阳",16);

        Stream<Map.Entry<String, Integer>> stream3 = map.entrySet().stream();
    }
}
