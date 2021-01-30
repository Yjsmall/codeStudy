package com.small.three;

/**
 * @author small
 */
public interface Selector {
    /**
     * 是否最后一个
     * @return true最后一个元素
     */
    boolean end();

    /**
     * 当前元素
     * @return Object
     */
    Object current();

    /**
     * 往下移动
     */
    void next();
}
