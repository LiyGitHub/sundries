package com.practice.bootintegrate.thread;

import java.util.concurrent.CompletableFuture;

/**
 * 线程池示例
 *
 * @author liy
 * @date 2023/12/6
 */
public class ThreadDemo {
    public CompletableFuture<String> asyncMethod() {
        return CompletableFuture.supplyAsync(() -> {
            // 模拟长时间运行的任务
            try {
                Thread.sleep(1000); // 模拟耗时操作
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Hello, Async World!";
        });
    }

    public void runAsyncExample() {
        CompletableFuture<String> future = asyncMethod();
        future.thenAccept(result -> {
            // 这个 lambda 表达式会在 future 完成时执行
            System.out.println("Result: " + result);
        });
        // 这里的代码会在 future 完成之前执行
        System.out.println("CompletableFuture 已启动");
    }

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        demo.runAsyncExample();
        try {
            // 等待时间应该比 CompletableFuture 执行的时间长
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
