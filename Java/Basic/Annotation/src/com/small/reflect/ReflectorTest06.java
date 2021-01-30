package com.small.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 反编译,获取属性
 * @author small
 */
public class ReflectorTest06 {
    public static void main(String[] args) throws Exception{
        //为了拼接字符串
        StringBuilder s = new StringBuilder();

        //Class stdClass = Class.forName("com.small.bean.Student");

        Class stdClass = Class.forName("java.lang.Thread");

        s.append(Modifier.toString(stdClass.getModifiers()) + "class" + stdClass.getSimpleName() + "{\n");

        Field[] fields = stdClass.getDeclaredFields();
        for(Field field : fields){
            s.append("\t");
            s.append(Modifier.toString(field.getModifiers()));
            s.append(" ");
            s.append(field.getType().getSimpleName());
            s.append(" ");
            s.append(field.getName());
            s.append(";\n");
        }


        s.append("}");
        System.out.println(s);
    }
}
