package com.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        Runnable task = () -> {
            for (int i = 0; i < 100; ++i) {
                synchronized (ThreadPoolTest.class) {
                    count += 1;
                }
            }
        };
        // 重要：创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        // 重要：向线程池提交两个任务
        threadPool.execute(task);
        threadPool.execute(task);

        // 等待线程池中的所有任务完成
        threadPool.shutdown();
        while (!threadPool.awaitTermination(1L, TimeUnit.MINUTES)) {
            System.out.println("Not yet. Still waiting for termination");
        }
        System.out.println("count = " + count);
    }

}
