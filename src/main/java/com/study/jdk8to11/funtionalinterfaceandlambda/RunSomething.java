package com.study.jdk8to11.funtionalinterfaceandlambda;

@FunctionalInterface
public interface RunSomething {
    void doRun();

    //함수형 인터페이스는 하나의 추상 메소드만 가질 수 있으므로 주석 해제 시 에러
    //void doIt();

    //스태틱 메소드
    static void staticPrint(){
        System.out.println("Static Method");
    }

    //디폴트 메소드
    default void defaultPrint(){
        System.out.println("default Method");
    }
}
