package com.ddu.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author Costar
 * @Date 周四 2024/4/18 22:48
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        MyRunnable task = new MyRunnable();
        pool.execute(task);
        pool.execute(task);
        pool.execute(task);

        pool.execute(task);
        pool.execute(task);
        pool.execute(task);

        pool.execute(task);
        pool.execute(task);
    }
}
