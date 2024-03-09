package com.practice.bootintegrate.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public enum ThreadPoolSingleton {
    INSTANCE;

    private ExecutorService executor;

    ThreadPoolSingleton() {
        // 初始化线程池，例如创建一个固定大小的线程池
        executor = Executors.newFixedThreadPool(10);
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    public static void main(String[] args) {
        // 获取线程池实例并提交任务
        ThreadPoolSingleton.INSTANCE.getExecutor().execute(() -> {
            System.out.println("任务执行中...");
        });
    }
}


