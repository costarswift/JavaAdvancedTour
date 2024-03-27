package com.ddu.ListDemo;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.SetUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 *
 * @author libo
 */
public class CollectionUtilsDemo {
    public static void main(String[] args) {
        List<String> emptyList = Collections.EMPTY_LIST;
        Set<String> emptySet = Collections.EMPTY_SET;
        Map<String, String> emptyMap = Collections.EMPTY_MAP;

        System.out.println("---------------------------------------");

        Collection<Object> objects = CollectionUtils.emptyCollection();
        List<Object> emptyList1 = Collections.emptyList();
        boolean b = CollectionUtils.isEmpty(emptyList);

        Set<String> strings = SetUtils.emptyIfNull(emptySet);


    }
}
