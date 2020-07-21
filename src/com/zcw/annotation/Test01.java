package com.zcw.annotation;

import java.util.ArrayList;

/**
 * @Author: AndrewBar
 * @Date: Created in 15:55 2020/7/12
 */
//什么是注解
@SuppressWarnings("all")
public class Test01 extends Object{

    //@Override  重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    //@Deprecated不推荐使用,但可以使用,或者存在更好地方式
    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }


    public void test02(){
        ArrayList<Object> list = new ArrayList<>();
    }

    public static void main(String[] args) {
        test();
    }
}
