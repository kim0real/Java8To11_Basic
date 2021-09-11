package com.study.jdk8to11.changeofinterface.defaultandstaticmethod;

public interface Foo {
    void printName();

    /**
     * @implSpec
     * 이 구현체는 getName()으로 가져온다.
     */
    default void printNameUpperCase(){
        System.out.println("Foo.printNameUpperCase");
        System.out.println(getName().toUpperCase());
    }

    String getName();

    static void print(){
        System.out.println("Call StaticMethod");
    }
}
