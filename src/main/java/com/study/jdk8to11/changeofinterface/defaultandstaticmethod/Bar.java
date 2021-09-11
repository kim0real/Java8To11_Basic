package com.study.jdk8to11.changeofinterface.defaultandstaticmethod;

public interface Bar {
    default void printNameUpperCase(){
        System.out.println("Bar.printNameUpperCase");
    }
}
