package com.small.reflect;

import com.small.bean.Student;

import java.lang.reflect.Field;

/**
 *
 * 掌握
 * @author small
 */
public class ReflectorTest07 {
    public static void main(String[] args) throws Exception{
        //只能这个Student对象写
        Student s = new Student();
        s.id = 111;
        System.out.println(s.id);

        /*
        1. 对象s          o对象
        2。id属性         id属性
        3。赋值111        2222
        反射可以，框架化,
         */
        Class sClass = Class.forName("com.small.bean.Student");

        //实例化一个对象
        Object o = sClass.newInstance();

        //2. 获取id属性
        Field id = sClass.getDeclaredField("id");

        //3. 给o对象（Student类型）的id赋值
        id.set(o,2222);

        //获取属性的值
        System.out.println(id.get(o));

        //私有属性
        Field name = sClass.getDeclaredField("name");
        //打破封装
        name.setAccessible(true);
        name.set(o,"王");
        System.out.println(name.get(o));

    }
}
