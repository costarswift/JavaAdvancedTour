package com.ddu.JsonDemo;

import com.alibaba.fastjson.JSONObject;
import com.ddu.VO.StudentVO;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author Costar
 * @Date 周日 2024/3/31 0:55
 */
public class JavaObjectTest {
    public static void main(String[] args) {
        Map<String, StudentVO> map = new HashMap<>(100);
        Random rdm = new Random();
        for (int i = 0; i < 100; i++) {
            StudentVO vo = new StudentVO();
            vo.setName("Tom" + i);
            vo.setAge(rdm.nextInt(18) + 18);
            vo.setPhoneNumber("15011115555");
            map.put("Id:" + i, vo);
        }

        JSONObject jsonObject = new JSONObject(100);
        jsonObject.putAll(map);
        System.out.println(jsonObject.getObject("Id:30", StudentVO.class).getAge());

    }
}
