package com.study.jdk8to11.changeofinterface.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 자바8 API의 기본 메소드와 스태틱 메소드
 * Interface : Spliterator
 */
public class Api_Spliterator {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("boot");
        name.add("msa");
        name.add("kafka");
        name.add("tdd");

        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();

        while(spliterator.tryAdvance(System.out::println));
        System.out.println("=========================");
        while(spliterator1.tryAdvance(System.out::println));
    }
}
