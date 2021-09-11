package com.study.jdk8to11.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsApp_II {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //소수의 풀로 여러 개의 스레드 작업이 가능하다.
        executorService.submit(getRunnable("Where"));
        executorService.submit(getRunnable("Why"));
        executorService.submit(getRunnable("What"));
        executorService.submit(getRunnable("How"));

        executorService.shutdown();
    }

    private static Runnable getRunnable(String massage){
        return () -> System.out.println(massage + Thread.currentThread().getName());
    }
}
