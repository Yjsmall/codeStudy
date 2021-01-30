package com.small.reflect;

/**
 * 可变长度参数
 *  int... args
 *  语法：类型。。。（三个点）
 *  可变长度参数只能一个，且放在最后
 * @author small
 */
public class ArgsTest {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        m();
        m(10,20);
        m(1,1,2);
        //也可以传入一个数组
        m(a);

    }

    /**
     * 错误 public static void(int... args,String... arg);
     * @param args Test
     */
    public static void m(int... args){
        System.out.println("m");
    }

    public static void m2(int n,String... args){
         //args有length属性，说明是一个数组
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
