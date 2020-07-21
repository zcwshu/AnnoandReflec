package com.zcw.reflection;

/**
 * @Author: AndrewBar
 * @Date: Created in 15:32 2020/7/21
 */
//测试类什么时候初始化
public class Test05 {
    static {
        System.out.println("main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用
        //Son son = new Son();

        //反射也会产生主动引用
        //Class.forName("com.zcw.reflection.Son");

        //不会产生类的引用的方法
        //子类调用父类的静态变量
        //System.out.println(Son.b);

        //数组创建不会加载
        //Son[] arr = new Son[5];

        //调用常量池中不会加载
        System.out.println(Son.M);
    }
}

class Father{
    static int b = 2;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static {
        System.out.println("子类被加载");
    }

    static int m = 100;
    static final int M = 1;
}