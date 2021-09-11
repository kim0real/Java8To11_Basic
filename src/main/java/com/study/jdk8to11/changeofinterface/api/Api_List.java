package com.study.jdk8to11.changeofinterface.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 자바8 API의 기본 메소드와 스태틱 메소드
 * Interface : List
 */
public class Api_List {
    public static void main(String[] args) {
        java.util.List<String> name = new ArrayList<>();
        name.add("boot");
        name.add("msa");
        name.add("kafka");

        name.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        //name.forEach(s -> System.out.println(s)); //Lambda Ver
        //name.forEach(System.out::println); //MethodReference Ver : 람다를 한번 더 줄여준다.

        System.out.println("====================");
        List<String> newName = name.stream().map(String::toUpperCase)
                     .filter(s -> s.startsWith("K"))
                     .collect(Collectors.toList());
        newName.forEach(System.out::println);

        System.out.println("====================");
        name.removeIf(s -> s.contains("k"));
        name.forEach(System.out::println);

        System.out.println("====================");
        name.add("kafka");
        name.sort(String::compareToIgnoreCase);
        name.forEach(System.out::println);
    }
}
