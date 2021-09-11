package com.study.jdk8to11.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalApp {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        /**
         * Optional에 값이 있는지 없는지 <-> isEmpty()
         */
        boolean present = optional.isPresent();
        System.out.println("present : " + present);

        /**
         * 값 꺼내기
         */
        if(optional.isPresent()) {
            OnlineClass onlineClass = optional.get();
            System.out.println("onlineClass.getTitle() : " + onlineClass.getTitle());
        }

        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        // 있으면 꺼내오고 없으면 새로운 클래스를 만드는 것 - createNewJpaClasses를 있을 때도 실행하고 없을 때도 실행한다.
        OnlineClass onlineClass = optional.orElse(createNewJpaClasses());
        System.out.println("onlineClass.getTitle() : " + onlineClass.getTitle());

        // 있으면 꺼내오고 없으면 새로운 클래스를 만드는 것 - 없는 경우에만 createNewJpaClasses을 실행한다.
        onlineClass = optional.orElseGet(OptionalApp::createNewJpaClasses);
        System.out.println(onlineClass.getTitle());

        //onlineClass = optional.orElseThrow(() -> new IllegalAccessError());
        onlineClass = optional.orElseThrow(IllegalAccessError::new);
        System.out.println(onlineClass.getTitle());

        Optional<Progress> onlineClass1 = optional.flatMap(OnlineClass::getProgress);
    }

    private static OnlineClass createNewJpaClasses(){
        System.out.println("App.createNewJpaClasses"); //
        return new OnlineClass(6, "New class", false);
    }
}
