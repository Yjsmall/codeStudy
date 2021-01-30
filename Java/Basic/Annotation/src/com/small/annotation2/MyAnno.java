package com.small.annotation2;

/**
 * @author small
 */
public @interface MyAnno {

    /**
     * 定义一个属性，MyAnno的name属性
     * String name（）
     * String name
     * 看起来像一个方法
     * @return name
     */
    String name();

    /**
     *
     * @return color
     */
    String color();

    /**
     * 指定默认值为25
     * @return age
     */
    int age() default 24;

    /**
     *
     * @return season
     */
    Season[] season();
}
