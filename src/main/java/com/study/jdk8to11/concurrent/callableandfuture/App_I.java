package com.study.jdk8to11.concurrent.callableandfuture;

import java.util.concurrent.*;

public class App_I {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(3000);
            return "hello";
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone()); // 작업이 끝났으면 true
        System.out.println("Started!");

        //취소 했으면 true 못했으면 false를 리턴한다.
        helloFuture.cancel(false);

        //값 꺼내기(값을 꺼낼 때 까지 기다린 후 다음 코드 실행)
        //helloFuture.get();

        System.out.println(helloFuture.isDone());
        System.out.println("End!");
        executorService.shutdown();
    }
}
