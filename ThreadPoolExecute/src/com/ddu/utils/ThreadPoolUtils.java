package com.ddu.utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author Costar
 * @Date 周四 2024/4/18 23:22
 */
public class ThreadPoolUtils {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 线程池不允许通过Executors去创建，而是通过new ThreadPoolExecutor()自己手动创建，
         * 这样开发者更明确线程池的运行规则，从而规避系统资源耗尽的风险。
         */
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(200));
        Future<String> f3 = pool.submit(new MyCallable(300));
        Future<String> f4 = pool.submit(new MyCallable(400));

        // submit()方法执行立即运行MyCallable里的call()方法
        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());
    }
}
