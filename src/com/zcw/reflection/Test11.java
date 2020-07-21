package com.zcw.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @Author: AndrewBar
 * @Date: Created in 20:48 2020/7/21
 */
public class Test11 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.zcw.reflection.Student2");

        //通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获取注解的value的值
        Tablezcw tablezcw = (Tablezcw) c1.getAnnotation(Tablezcw.class);
        String value = tablezcw.value();
        System.out.println(value);

        //获取类指定注解
        Field name = c1.getDeclaredField("name");
        Fieldzcw annotation = name.getAnnotation(Fieldzcw.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.length());
        System.out.println(annotation.type());
    }
}

@Tablezcw("db_student")
class Student2{

    @Fieldzcw(columnName = "db_name",type="varchar",length=3)
    private String name;
    @Fieldzcw(columnName = "db_age",type="int",length=10)
    private int age;
    @Fieldzcw(columnName = "db_id",type="int",length=10)
    private int id;

    public Student2() {
    }

    public Student2(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface  Tablezcw{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldzcw{
    String columnName();
    String type();
    int length();
}