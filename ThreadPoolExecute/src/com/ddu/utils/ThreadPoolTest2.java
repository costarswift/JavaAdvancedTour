package com.ddu.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author Costar
 * @Date 周四 2024/4/18 23:08
 */
public class ThreadPoolTest2 {
    public static void main(String[] args) throws Exception {
    ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 10,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());

        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(200));
        Future<String> f3 = pool.submit(new MyCallable(300));

        Future<String> f4 = pool.submit(new MyCallable(400));
        Future<String> f5 = pool.submit(new MyCallable(500));
        Future<String> f6 = pool.submit(new MyCallable(600));

        Future<String> f7 = pool.submit(new MyCallable(700));
        Future<String> f8 = pool.submit(new MyCallable(800));
        Future<String> f9 = pool.submit(new MyCallable(900));

        // submit()方法执行立即运行MyCallable里的call()方法
        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());
        System.out.println(f5.get());
        System.out.println(f6.get());
        System.out.println(f7.get());
        System.out.println(f8.get());
        System.out.println(f9.get());
    }
}
