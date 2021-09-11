package com.study.jdk8to11.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasicApp {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("rds");
        names.add("mst");
        names.add("querydsl");

        //중간 연산자는 Lazy하다. : 최종 연산자가 나오기 전까지 출력이 되지 않는다.
        names.stream().map((s) -> {
                    System.out.println("중간 연산자 출력");
                    return s.toUpperCase();
                });

        System.out.println("=========================");
        List<String> newNames = names.stream().map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        newNames.forEach(System.out::println);

        System.out.println("=========================");
        //병렬성 처리 parallelStream()가  데이터량이 방대할 때를 제외하곤 꼭 유리한 것은 아니다.
        newNames = names.parallelStream().map(s -> {
                    System.out.println(s + " " + Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .collect(Collectors.toList());
        newNames.forEach(System.out::println);



    }
}
