package com.small.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 反射Student类中的全部属性
 * @author small
 */
public class ReflectorTest05 {
    public static void main(String[] args) throws Exception{
        //获取整个类
        Class stdClass = Class.forName("com.small.bean.Student");
        System.out.println("完整类名" + stdClass.getName());
        System.out.println("简单名字" + stdClass.getSimpleName());

        //获取类中的所有field
        Field[] fields = stdClass.getFields();
        System.out.println(fields.length);

        //取出这个field的名字
        String name = fields[0].getName();
        System.out.println(name);

        //获取所有field
        Field[] fs = stdClass.getDeclaredFields();
        System.out.println(fs.length);

        System.out.println("========");

        //遍历
        for (Field field : fs) {
            System.out.println("-");

            //获取属性修饰符,返回的修饰符是一个数字，每个数字是修饰符的代号
            int i = field.getModifiers();
            System.out.println(i);
            //代号---->字符串
            String s = Modifier.toString(i);
            System.out.println(s);

            //获取属性的类型
            Class<?> type = field.getType();
            String fName = type.getName();
            System.out.println(fName);

            //获取属性的名字
            System.out.println(field.getName());
        }



    }
}
