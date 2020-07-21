package com.zcw.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: AndrewBar
 * @Date: Created in 19:41 2020/7/21
 */
//动态创建对象,通过反射
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得class对象
        Class c1 = Class.forName("com.zcw.reflection.User");

        //构造一个对象
        User user = (User) c1.newInstance();//本质调用无参构造
        System.out.println(user);

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User) constructor.newInstance("zcw", 001, 18);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        //通过反射获取方法
        Method setName = c1.getDeclaredMethod("setName", String.class);

        //invoke : 激活
        //(对象 , "方法的值")
        setName.invoke(user3,"赵成伟");
        System.out.println(user3.getName());

        //通过反射操作属性
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");

        name.setAccessible(true);
        name.set(user4,"zcw");
        System.out.println(user4.getName());

    }
}
