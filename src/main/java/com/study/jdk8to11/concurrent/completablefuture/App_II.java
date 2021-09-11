package com.study.jdk8to11.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App_II {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello: " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> future = hello.thenCompose(App_II::getWorld);

        System.out.println(future.get());
    }

    private static CompletableFuture<String> getWorld(String message){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World: " + Thread.currentThread().getName());
            return message + "World";
        });
    }
}
