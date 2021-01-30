package com.small.reflect;

/**
 * 重点
 * @author small
 */
public class ReflectorTest10 {
    public static void main(String[] args) throws Exception{
        Class sClass = Class.forName("java.lang.String");

        //获取类的父类
        Class superclass = sClass.getSuperclass();
        System.out.println(superclass.getName());
        System.out.println("===");

        //获取String类实现的所有接口
        Class[] interfaces = sClass.getInterfaces();
        for (Class in : interfaces){
            System.out.println(in.getName());
        }


    }
}
