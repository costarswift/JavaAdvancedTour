package com.ddu.JsonDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ddu.VO.StudentVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author Costar
 * @Date 周日 2024/3/31 0:18
 */
public class JasonArrayTest {
    public static void main(String[] args) {
        List<StudentVO> students = new ArrayList<>(100);
        JSONArray jsonArray = new JSONArray(100);
        Random rdm = new Random();
        for (int i = 0; i < 100; i++) {
            StudentVO vo = new StudentVO();
            vo.setName("Tom" + i);
            vo.setAge(rdm.nextInt(18) + 18);
            vo.setPhoneNumber("15011115555");
            students.add(vo);
            jsonArray.add(vo);
        }
        System.out.println(JSON.toJSONString(students));

        String jsonString = JSON.toJSONString(jsonArray);
        System.out.println(jsonString);

        List<StudentVO> javaList = jsonArray.toJavaList(StudentVO.class);
        for (StudentVO vo : javaList) {
            System.out.println("My name is " + vo.getName() + ", and I'm " + vo.getAge() + " years old.");
        }

    }
}
