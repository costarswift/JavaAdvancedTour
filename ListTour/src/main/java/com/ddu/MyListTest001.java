package com.ddu;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Costar
 * @Date 周四 2024-11-21 23:29
 */


public class MyListTest001 {
    public static void main(String[] args) {
        List<String> stringList = List.of("A", "B", "C", "D", "E");
        List<String> stringList1 = Arrays.asList("A", "B", "C", "D", "E");

        try {
            stringList.add("F"); // 底层是不可修改的列表
        } catch (Exception e) {
            System.out.println(e);
        }
        stringList1.set(0, "F");
        String s = stringList1.get(0);
        System.out.println(s);
        assert "F".equals(s);

        stringList1.add("F"); // 底层是可修改的列表，但是内部子类ArrayList没有add方法，所以会报错

    }
}
