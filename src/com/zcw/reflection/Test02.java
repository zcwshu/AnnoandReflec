package com.zcw.reflection;

import java.lang.annotation.Inherited;

/**
 * @Author: AndrewBar
 * @Date: Created in 17:32 2020/7/12
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是" + person.name);

        //方式一 :通过对象获得
        Class c1 = person.getClass();

        //方式二 : forname获得,包名
        Class c2 = Class.forName("com.zcw.reflection.Student");

        //方式三 : 通过类名.class获得
        Class c3 = Student.class;

        //方式四: 基本内置类型的包装类都有一个type属性
        Class c4 = Integer.TYPE;

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4);

        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);

        Class c6 = c5.getSuperclass();
        System.out.println(c6);

    }
}

class Person{
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{
    public Student(){
        this.name="学生";
    }
}

class Teacher extends Person{
    public Teacher(){
        this.name="老师";
    }
}