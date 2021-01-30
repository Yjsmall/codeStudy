package com.small.reflect;

/**
 * @author small
 * 三种方法获取这个类的字节码
 * 返回都是Class类型
 * 1。Class.forName("完整包名+类名");
 * 2. 对象.getClass(); 是Object中的方法(老祖宗的方法）
 * 3. 基本类型.class
 */
public class ReflectorTest01 {
    public static void main(String[] args) {
        /*
          Class.forName()
          1. 静态方法
          2. 方法参数字符串
          3. 完整类名+包名
         */
        Class c1 = null;
        try {
            c1 = Class.forName("java.lang.String");
            System.out.println(c1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // java中任何对象都有一个get.class文件
        String s = "abc";
        //x代表String.class字节码文件，x代表String类型
        Class x = s.getClass();
        //判断内存地址,JVM方法区只有一份字节码，
        System.out.println(c1 == x);

        Class s2 = String.class;
        System.out.println(s2 == x);

    }
}
