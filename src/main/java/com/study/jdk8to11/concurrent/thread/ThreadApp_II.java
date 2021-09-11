package com.study.jdk8to11.concurrent.thread;

public class ThreadApp_II {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(true){
                System.out.println("Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("exit!");
                    return;
                }
            }
        });
        thread.start();

        System.out.println("Thread: " + Thread.currentThread().getName());
        Thread.sleep(1000);
        thread.interrupt();

    }
}
