package com.small.annotation3;

import java.lang.reflect.Method;

/**
 * @author small
 */
public class MyAnnoTest {
    @MyAnno(username = "admin",pwd = "123")
    public void doSome(){}

    public static void main(String[] args) throws Exception {
        //获取MyAnnoTest的doSome（）方法上面的注解信息
        Class c = Class.forName("com.small.annotation3.MyAnnoTest");

        //获取doSome（）方法
        Method doSome = c.getDeclaredMethod("doSome");

        //判断方法是否存在这个注解
        if (doSome.isAnnotationPresent(MyAnno.class)){
            //有，就获取这个注解
            MyAnno annotation = doSome.getAnnotation(MyAnno.class);
            System.out.println(annotation.username());
            System.out.println(annotation.pwd());
        }
    }
}
