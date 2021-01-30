package com.small.lab1;

/**
 * @author small
 */
public class Node{
    /**
     * 数据域:
     * 进程名,优先级,运行时间,到达时间
     * 开始时间,结束时间,周转时间,带权周转时间
     * 指针域:
     * nextNode
     */
    String name;
    int priority;
    int runtime;
    int arrivalTime;

    int starttime;
    int endtime;
    //周转时间
    int turntime;
    //带权周转时间
    double dturntime;
    int statu;
    int newarrival;
    int newruntime;

    Node nextNode;

    public Node(String name,int priority,int runtime,int arrivalTime, int starttime, int endtime, int turntime, double dturntime){
        this.name = name;
        this.priority = priority;
        this.runtime = runtime;
        this.arrivalTime = arrivalTime;
        this.nextNode = null;
        this.starttime = starttime;
        this.endtime = endtime;
        this.turntime = turntime;
        this.dturntime = dturntime;
        this.newarrival = arrivalTime;
        this.newruntime = runtime;
    }

}

