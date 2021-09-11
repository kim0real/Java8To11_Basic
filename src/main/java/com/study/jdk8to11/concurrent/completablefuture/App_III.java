package com.study.jdk8to11.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App_III {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello: " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World: " + Thread.currentThread().getName());
            return "World";
        });

        //CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> h + " " + w);
        //System.out.println(future.get());

        /*
        List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);

        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));

        results.get().forEach(System.out::println);
         */

        CompletableFuture<Void> future = CompletableFuture.anyOf(hello, world).thenAccept(System.out::println);
        System.out.println(future.get());

    }
}
