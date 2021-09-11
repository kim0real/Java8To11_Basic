package com.study.jdk8to11.concurrent.thread;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e){
                throw new IllegalStateException(e);
            }
        });
        thread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
        try {
            //메인 스레드가 위 thread를 기다림
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(thread + " is finished");

    }
}
