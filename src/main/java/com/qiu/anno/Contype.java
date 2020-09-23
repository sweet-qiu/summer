package com.qiu.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//被反射读取到
@Target(ElementType.METHOD)//用在方法上
public @interface Contype {
    String value();
}
