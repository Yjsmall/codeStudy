package com.small.process;

/**
 * @author small
 */
public class JCB {
    /**
     * 进程名---到达时间---服务时间---开始时间---结束时间
     */
    String name;
    int arriveTime;
    int serveTime;
    int beginTime;
    int finshTime;
    /**
     * 周转时间--带权周转时间
     */
    int roundTime;
    double aveRoundTime;
    /**
     * 在时间轮转调度算法中，记录该进程真实服务时间已经用时的时长
     * 记录每个进程到达后的等待时间，只用于最高响应比优先调度算法中
     * 在RR算法中标识开始时间是否第一次计算
     */
    double clock=0;
    int waitTime;
    boolean firstTimeTag=false;

    public JCB() {
    }
    public JCB(String name, int arriveTime, int serveTime,double priority) {
        super();
        this.name = name;
        this.arriveTime = arriveTime;
        this.serveTime = serveTime;
        this.waitTime=0;
    }

    @Override
    public String toString() {
        return "进程名：P" + this.name;
    }
}

