package com.study.jdk8to11.concurrent.callableandfuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App_II {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep(2000);
            return "hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000);
            return "java";
        };

        Callable<String> zero = () -> {
            Thread.sleep(1000);
            return "zero";
        };

        //동시에 실행한 작업 중에 제일 오래 걸리는 작업 만큼 시간이 걸린다.
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, zero));
        for(Future<String> f : futures){
            System.out.println(f.get());
        }

        //여러 작업 중에 하나라도 먼저 응답이 오면 끝내기
        String futuresString = executorService.invokeAny(Arrays.asList(hello, java, zero));
        System.out.println(futuresString); // zero



        executorService.shutdown();
    }
}
