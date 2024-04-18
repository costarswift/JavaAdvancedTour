package com.ddu.utils;

/**
 * @Author Costar
 * @Date 周四 2024/4/18 22:57
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "执行了。。。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
