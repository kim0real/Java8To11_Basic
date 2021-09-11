package com.study.jdk8to11.changeofinterface.defaultandstaticmethod;

public class App {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("Zero");
        foo.printName();

        //Use DefaultMethod
        foo.printNameUpperCase();

        //Use StaticMethod
        Foo.print();
    }
}
