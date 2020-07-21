package com.zcw.annotation;

import java.lang.annotation.*;

/**
 * @Author: AndrewBar
 * @Date: Created in 16:22 2020/7/12
 */
//测试元注解
@MyAnnotation
public class Test02 {

    @MyAnnotation
    public void test(){

    }
}

//定义一个注解


//target 表示我们的注解可以用在哪些地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})

//Retention  表示注解在什么地方有效
//runtime > class > source
@Retention(value = RetentionPolicy.RUNTIME)

//表示是否将我们的注解生成在JavaDoc中
@Documented

//表示子类可以继承父类的注解
@Inherited
@interface MyAnnotation{

}
