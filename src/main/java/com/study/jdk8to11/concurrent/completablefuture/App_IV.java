package com.study.jdk8to11.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App_IV {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        boolean throwError = true;

        //예외처리
        /*
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("World: " + Thread.currentThread().getName());
            return "World";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error!";
        });
         */

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("World: " + Thread.currentThread().getName());
            return "World";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return "error!";
            }
            return result;
        });

        System.out.println(world.get());
    }
}
