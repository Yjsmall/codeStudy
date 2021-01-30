package com.small.reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

/**
 * 反射机制的灵活性
 * java代码写一遍，不改变java源代码的基础上，可以做到不同对象的实例化
 * @author small
 */
public class ReflectorTest03 {
    public static void main(String[] args) throws Exception {
        //只能创建一个实例User user = new User（）;

        //通过IO读取配置文件，只要修改配置文件，可以创建不同实例
        FileReader reader = new FileReader("src/com/small/reflect/classinfo.properties");

        //创建属性类对象Map
        Properties pro = new Properties();

        //加载
        pro.load(reader);

        //关闭流
        reader.close();

        //通过key获取value
        String className = pro.getProperty("className");
        String classDate = pro.getProperty("classDate");
        System.out.println(className);
        System.out.println(classDate);
        System.out.println("--------");

        //反射机制实例化对象,会默认调用无参构造方法
        Class c = Class.forName(className);
        System.out.println(c.newInstance());
        System.out.println(Class.forName(classDate).newInstance());


    }
}
