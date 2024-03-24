package com.ddu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

/**
 * @Author Costar
 * @Date 周五 2024/2/23 22:23
 */
public class LambdaDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A new thread has been executed");
            }
        }).start();

        //Replace with lambda
        new Thread(() -> System.out.println("A new thread has been executed")).start();

        int result = calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
        System.out.println(result);

        int result1 = calculateNum((left, right) -> left + right);
        System.out.println(result1);

        int result2 = calculateNum(Integer::sum);
        System.out.println(result2);

        printNum(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value % 2 == 0;
            }
        });

        printNum(value -> value % 2 == 0);
    }

    private static int calculateNum(IntBinaryOperator intBinaryOperator) {
        int var1 = 10;
        int var2 = 20;
        return intBinaryOperator.applyAsInt(var1, var2);
    }

    private static void printNum(IntPredicate intPredicate) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }

        for (Integer num : nums) {
            if (intPredicate.test(num)) {
                System.out.println(num);
            }
        }
    }
}
