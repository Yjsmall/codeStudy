package com.small.reflect;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author small
 */
public class AboutPath {
    public static void main(String[] args) throws IOException {
        //ReflectorTest03文件路径，移植性差，IDEA默认是project的跟
        //离开IDEA，换到其他位置，就可能不是project的跟

        //通用格式，在类目录文件下，src下就行
        /*
        解释：
        1。Thread.currentTread():当前线程
        2. getContextClassLoader():线程对象的方法，可以获取当前线程的类加载器
        3. getResource():获取资源，类加载器对象的方法
        方式一：获取绝对路径
         */
        String path = Thread.currentThread().getContextClassLoader().getResource("com/small/reflect/classinfo.properties").getPath();
        System.out.println(path);

        FileReader file = new FileReader(path);
        Properties pro = new Properties();
        pro.load(file);
        file.close();
        //通过key-value获取值
        String className = pro.getProperty("className");
        System.out.println(className);
        System.out.println("--------");

        //方式二：直接通过 流 返回--这里reader相当于上面的file
        InputStream reader = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/small/reflect/classinfo.properties");
        Properties properties = new Properties();
        properties.load(reader);
        reader.close();
        String date = properties.getProperty("classDate");
        System.out.println(date);


    }
}
