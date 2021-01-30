package com.small.reflect;

import com.small.bean.User;

/**
 * 反射能干什么
 * @author small
 *
 */
public class ReflectorTest02 {
    public static void main(String[] args) {
        Class c = null;
        try {
            //通过反射机制，获取class，通过class实例化对象
            c = Class.forName("com.small.bean.User");

            //c是User类型，newInstance实例化会调用无参构造方法，必须存在
            Object obj = c.newInstance();
            System.out.println(obj);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
