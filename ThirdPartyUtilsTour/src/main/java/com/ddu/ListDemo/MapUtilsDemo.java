package com.ddu.ListDemo;

import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Costar
 * @Date 周日 24/3/2024 下午 8:52
 */
public class MapUtilsDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "壹");
        map.put("2", "贰");
        Map<String, String> unmodifiableMap = MapUtils.unmodifiableMap(map);
        map.put("三", "叁");
        //unmodifiableMap.put("三", "叁");
        int size = unmodifiableMap.size();
        System.out.println(size);

        System.out.println(MapUtils.getLong(map, "1"));
        System.out.println(MapUtils.getString(map, "1"));
    }

}
