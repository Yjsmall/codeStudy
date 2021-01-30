package com.small.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/**
 * 了解内容
 * @author small
 */
public class ReflectTest08 {
    public static void main(String[] args) throws Exception {
        Class<?> uClass = Class.forName("com.small.service.UserService");

        //获取所有方法
        Method[] methods = uClass.getDeclaredMethods();
        System.out.println(methods.length);

        for(Method method : methods){
            System.out.println("--");
            //获取所有修饰符
            System.out.println(Modifier.toString(method.getModifiers()));

            //获取方法返回值类型
            Class<?> returnType = method.getReturnType();
            System.out.println(returnType);

            //获取方法名
            System.out.println(method.getName());

            //方法参数列表
            TypeVariable<Method>[] typeParameters = method.getTypeParameters();
            System.out.println(Arrays.toString(typeParameters));
        }

    }
}
