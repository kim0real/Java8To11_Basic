package com.study.jdk8to11.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE_PARAMETER)
@Target(ElementType.TYPE_USE)
@Repeatable(ChickenContainer.class)
public @interface Chicken {
    String value();
}
