package com.ddu;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.list.UnmodifiableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Costar
 * @Date 周五 2024-10-11 23:04
 */
public class CollectionUtilsTest {
    public static void main(String[] args) {
        List<String> list = List.of("1", "2", "3"); // immutable
        list.forEach(System.out::println);

        List<String> list2 = Arrays.asList("1", "2", "3");  // immutable
        /*list2.add("4");
        list2.remove("1");
        list2.set(1, "5");*/

        System.out.println(list2);

        List<String> list3 = new ArrayList<>(list2);
        UnmodifiableList<String> unmodifiableList = new UnmodifiableList<>(list3);
        System.out.println(unmodifiableList);
        list3.add("4");
        System.out.println(unmodifiableList);

        System.out.println(list.contains("1"));

        System.out.println(CollectionUtils.isEmpty(list));


        // -----------------------

        List<String> unmodifiabledList = Collections.unmodifiableList(list2);

    }
}
