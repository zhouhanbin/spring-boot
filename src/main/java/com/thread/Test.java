package com.thread;

import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    private static int count = 0;
    public static void main(String[] args) throws Exception {
        Runnable task = () -> {
            for (int i = 0; i < 1000; ++i) {
                synchronized (Test.class) {
                    count += 1;
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        // 等待t1和t2执行完成
        t1.join();
        t2.join();
        System.out.println("count = " + count);

    }
}
