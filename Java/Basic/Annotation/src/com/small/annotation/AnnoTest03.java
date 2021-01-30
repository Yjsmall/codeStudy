package com.small.annotation;

/**
 * //表示已经过时
 * @author small
 */
public class AnnoTest03 {
    public static void main(String[] args) {
        AnnoTest03.doSome();
    }

    @Deprecated
    public static void doSome(){
        System.out.println("do it");
    }
}
