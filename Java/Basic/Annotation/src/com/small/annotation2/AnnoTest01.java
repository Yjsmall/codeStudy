package com.small.annotation2;

/**
 * @author small
 */
public class AnnoTest01 {
    /**
     * 如果注解只有一个，且属性名是value，则可以省略属性名，直接写值
     */
    @OnlyAnno("haha")
    int value;

    @MyAnno(name = "name",color = "red",season = Season.SUMMER)
    int season;

    /**
     * 有属性，就要指定默认值
     */
    @MyAnno(name = "name",color = "red",season = {Season.AUTUMN,Season.SUMMER})
    public void doSome(){
    }

}
