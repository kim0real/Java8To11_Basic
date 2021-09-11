package com.study.jdk8to11.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsApp_III {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        ((ScheduledExecutorService) executorService).scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);
    }

    private static Runnable getRunnable(String massage){
        return () -> System.out.println(massage + Thread.currentThread().getName());
    }
}
