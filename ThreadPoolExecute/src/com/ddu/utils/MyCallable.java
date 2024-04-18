package com.ddu.utils;

import java.util.concurrent.Callable;

/**
 * @Author Costar
 * @Date 周四 2024/4/18 23:04
 */
public class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        System.out.println(n + "以内正整数的和");
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += i;
        }
        return Thread.currentThread().getName() + "求出1-" + n + "的和是：" + ans;
    }
}
