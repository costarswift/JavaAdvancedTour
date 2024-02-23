package com.ddu;

import java.util.function.Function;
import java.util.function.IntConsumer;

/**
 * @Author Costar
 * @Date 周五 2024/2/23 23:08
 */
public class PatternDemo {
    public static void main(String[] args) {
        Integer integer = typeConvert(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        });
        System.out.println(integer);
        System.out.println(integer.getClass());

        //Replace with lambda
        Integer integer1 = typeConvert(s -> Integer.valueOf(s));
        System.out.println(integer1);

        Integer integer2 = typeConvert(Integer::valueOf);
        System.out.println(integer2);

        System.out.println("-----------------------------------------------");

        Character ch = typeConvert(new Function<String, Character>() {
            @Override
            public Character apply(String s) {
                return s.charAt(0);
            }
        });
        System.out.println(ch);

        Character ch1 = typeConvert(s -> s.charAt(0));
        System.out.println(ch1);

        System.out.println("-----------------------------------------------");

        forEachArrayElement(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value * 2);
            }
        });

        forEachArrayElement(value -> System.out.println(value * 2));
    }

    private static <R> R typeConvert(Function<String, R> function) {
        String str = "12345";
        return function.apply(str);
    }

    private static void forEachArrayElement(IntConsumer intConsumer) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        for (int i : arr) {
            intConsumer.accept(i);
        }
    }
}
