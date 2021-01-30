package com.small.reflect;

import com.small.service.UserService;

import java.lang.reflect.Method;

/**
 * 掌握
 * 要素分析
 * 1。对象userService  obj
 * 2. login方法名  对象.invoke调用这个对象的方法
 * 3. 实惨列表  类.getDeclaredMethod
 * 4. 返回值   reValue
 * @author small
 */
public class ReflectorTest09 {
    public static void main(String[] args) throws Exception{
        //不使用反射机制
        UserService userService = new UserService();
        boolean admin = userService.login("admin", "123");
        System.out.println(admin ? "登陆成功" : "登陆失败");


        //使用反射
        Class uClass = Class.forName("com.small.service.UserService");
        //创建对象
        Object ob = uClass.newInstance();
        //获取方法
        Method login = uClass.getDeclaredMethod("login", String.class, String.class);
        //传入参数
        boolean reValue = (boolean) login.invoke(ob, "admin", "123");
        System.out.println(reValue);

    }
}
