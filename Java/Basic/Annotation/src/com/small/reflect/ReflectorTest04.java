package com.small.reflect;

/**
 * @author small
 */
public class ReflectorTest04 {
    public static void main(String[] args) {
        try {
            //forName执行类中静态代码块(只希望执行类中的静态代码块，类中代码一律不执行)
            Class.forName("com.small.reflect.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class MyClass {
    //静态代码块在类中加载时，并且只执行一次
    static {
        System.out.println("静态代码块执行");
    }
}
