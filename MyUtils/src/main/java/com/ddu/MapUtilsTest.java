package com.ddu;

import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;

/**
 * @Author Costar
 * @Date 周五 2024-10-11 23:01
 */
public class MapUtilsTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "2");
        map.put("2", "3");
        map.put("3", "4");

        System.out.println(MapUtils.isEmpty(map));
    }
}
