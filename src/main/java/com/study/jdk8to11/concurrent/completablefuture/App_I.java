package com.study.jdk8to11.concurrent.completablefuture;

import java.util.concurrent.*;

public class App_I {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        CompletableFuture<Object> future = new CompletableFuture<>();
        future.complete("zero");
         */
        //Java8 이후 추가 : CompletableFuture
        /*
        CompletableFuture<Object> future = CompletableFuture.completedFuture("zero");
         */

        //리턴타입이 없는 경우
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Hello:" + Thread.currentThread().getName());
        });
        future.get();

        //리턴타입이 있는 경우
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello:" + Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println(future1.get());

        //리턴타입이 있는 경우
        CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello:" + Thread.currentThread().getName());
            return "Hello";
        }).thenAccept((s) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });
        System.out.println(future2.get());

        CompletableFuture<Void> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello:" + Thread.currentThread().getName());
            return "Hello";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println(future3.get());



    }
}
