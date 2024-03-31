package com.ddu.JsonDemo;

import com.alibaba.fastjson.JSON;
import com.ddu.VO.StudentVO;

/**
 * @Author Costar
 * @Date 周六 2024/3/30 23:59
 */
public class JsonTest1 {
    public static void main(String[] args) {
        StudentVO tom = new StudentVO("Tom", 18, "13012348888");
        String jsonString = JSON.toJSONString(tom);
        System.out.println(jsonString);

        StudentVO tom1 = JSON.parseObject(jsonString, StudentVO.class);
        System.out.println(tom1.getName());

        System.out.println(tom);
        System.out.println(tom1);
        System.out.println(tom == tom1); //保装类比较的是内存地址

        System.out.println(tom.equals(tom1)); //equals方法比较的是内部成员变量的值
    }
}
