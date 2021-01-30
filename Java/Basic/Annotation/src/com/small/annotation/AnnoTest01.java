package com.small.annotation;

/**
 * @author small
 */
public class AnnoTest01 {
    @MyAnno
    private int no;

    @MyAnno
    public AnnoTest01(){

    }

    @MyAnno
    public static void m1(){
        @MyAnno
        int i = 100;

    }

    public void m2(@MyAnno String name){

    }
}
