package com.small.reflect;

import java.util.ResourceBundle;

/**
 * @author small
 */
public class ResourceBundleTest {
    public static void main(String[] args) {
        //资源绑定器，不需要加拓展名,只能绑定xxx.properties文件
        //都是src作为起点
        ResourceBundle bundle = ResourceBundle.getBundle("com/small/reflect/classinfo");

        //通过key获取value
        String className = bundle.getString("className");
        System.out.println(className);
    }
}
