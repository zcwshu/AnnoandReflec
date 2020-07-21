package com.zcw.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: AndrewBar
 * @Date: Created in 18:53 2020/7/21
 */
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.zcw.reflection.User");

        User user = new User();
        c1 = user.getClass();
        //获得类的名字
        System.out.println(c1.getName()); //获得包名 + 类名
        System.out.println(c1.getSimpleName());//获得类名

        //获得类的属性
        Field[] fields = c1.getFields();//只能找到public
        for (Field field : fields) {
            System.out.println(field);
        }

        fields = c1.getDeclaredFields();//找到全部
        for (Field field : fields) {
            System.out.println(field);
        }
        //获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        Method[] methods = c1.getMethods();//本类及父类全部public方法
        for (Method method : methods) {
            System.out.println(method);
        }

        methods = c1.getDeclaredMethods();//获得本类全部方法
        for (Method method : methods) {
            System.out.println(method);
        }

        //获得构造器
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println(declaredConstructor);
    }
}
