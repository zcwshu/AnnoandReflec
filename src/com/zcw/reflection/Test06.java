package com.zcw.reflection;

/**
 * @Author: AndrewBar
 * @Date: Created in 16:48 2020/7/21
 */
public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException {

        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器-->扩展类
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器-->根加载器(c/C++)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类的类加载器
        ClassLoader classLoader = Class.forName("com.zcw.reflection.Test06").getClassLoader();
        System.out.println(classLoader);

        //获得JDK内置的类是谁加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
