package com.small.mine;

/**
 * @author small
 * 1. 先初始化变量
 * 2. 执行静态代码块
 * 3. 构造函数
 */
public class StaticTest {
    static int i = 0;

    static {
        System.out.println(i + "");
        System.out.println("This is static code");
        i = 9;
        System.out.println(i + "");
    }

    {
        System.out.println("隐式静态代码块");
    }

    StaticTest(){
        System.out.println("This is construct scope");
    }

    public static void main(String[] args) {
        new StaticTest();
        System.out.println("----");
        for (String s : args) {
            System.out.print(s + "");
        }


    }
}

class DynamicArray {
    public static void main(String[] args) {
        StaticTest.main(new String[]{"hello","world"});
    }

}
