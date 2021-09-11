package com.study.jdk8to11.annotation;

import java.util.Arrays;

@Chicken("양념")
@Chicken("간장")
public class App {
    public static void main(String[] args) {
        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> System.out.println(c.value()));

        ChickenContainer chickenContainers = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainers.value()).forEach(c -> {
            System.out.println(c.value());
        });
    }
}
