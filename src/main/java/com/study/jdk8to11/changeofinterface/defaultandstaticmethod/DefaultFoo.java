package com.study.jdk8to11.changeofinterface.defaultandstaticmethod;

public class DefaultFoo implements Foo, Bar{
    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    /**
     * Interface의 DefaultMethod를 안받아도 되며 오버라이드받아 재정의할 수도 있다.
     * 재정의할 경우 인터페이스보다 우선권을 가진다.
     * 또한 Foo, Bar 둘다 같은 이름의 Default 메소드를 가지고 있을 경우 컴파일 에러가 나므로 무조건적으로 재정의해야한다.
     */
    @Override
    public void printNameUpperCase() {
        System.out.println("DefaultFoo.printNameUpperCase");
        System.out.println(this.name.toUpperCase());
    }

    @Override
    public void printName() {
        System.out.println(this.name);

    }

    @Override
    public String getName() {
        return this.name;
    }
}
