package com.study.jdk8to11.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsApp_I {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        });

        executorService.shutdown();
        //executorService.shutdownNow();
    }

}
