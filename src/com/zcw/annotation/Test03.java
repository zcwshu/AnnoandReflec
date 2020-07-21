package com.zcw.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: AndrewBar
 * @Date: Created in 16:47 2020/7/12
 */
//自定义注解
public class Test03 {

    @MyAnnotation2(name = "赵成伟",schools = {"西工大","西北大学"})
    public void test(){

    }

    @MyAnnotation3("赵成伟")
    public void test2(){

    }
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数 : 参数类型 + 参数名();
    String name() default "";
    int age() default 0;
    int id() default -1;//如果默认值为-1,代表不存在,indexof,如果找不到也返回-1

    String[] schools() default {"上海大学","清华大学"};
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value();
}
