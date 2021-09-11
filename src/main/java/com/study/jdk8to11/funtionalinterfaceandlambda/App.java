package com.study.jdk8to11.funtionalinterfaceandlambda;

import java.util.function.Function;
import java.util.function.UnaryOperator;

class Student{
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String hi(String name){
        return "hi : " + name;
    }
}

public class App {
    public static void main(String[] args) {
        Student student = new Student("");
        System.out.println("Use NewOperator : " + student.hi("김영웅"));

        UnaryOperator<String> greeting = student::hi;

        Function<String, String> function = (i) -> "hi : " + i;
        System.out.println("Use Lambda : " + function.apply("김영웅") );


    }
}
