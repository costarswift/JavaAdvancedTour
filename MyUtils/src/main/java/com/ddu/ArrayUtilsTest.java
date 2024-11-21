package com.ddu;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author Costar
 * @Date 周五 2024-10-11 22:57
 */
public class ArrayUtilsTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ArrayUtils.add(arr, 6);

        System.out.println(ArrayUtils.toString(arr));

        System.out.println(ArrayUtils.isEmpty(arr));

        Map emptyMap = Collections.EMPTY_MAP;
        Set emptySet = Collections.EMPTY_SET;
        List emptyList = Collections.EMPTY_LIST;

        Collection<Object> emptyCollection = CollectionUtils.emptyCollection();
        List<Object> emptyList1 = Collections.emptyList();

        int i = 1;
        int j = i << 1;
        System.out.println("i: " + i + ", j: " + j);
    }
}
