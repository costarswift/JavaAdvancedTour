package com.ddu.ListDemo;


import org.apache.commons.lang3.StringUtils;

/**
 * @Author Costar
 * @Date 周日 24/3/2024 下午 8:46
 */
public class StringUtilsDemo {
    public static void main(String[] args) {
        String string1 = "String1";
        String string2 = "String2";

        System.out.println(StringUtils.isAllBlank(string1, string2));
        System.out.println(StringUtils.isAnyBlank(string1, string2));
        System.out.println(StringUtils.equals(string1, string2));
    }
}
