package com.small.lab3;


import java.util.Scanner;

/**
 * @author small
 */
public class Bank {
    /**
     * 可利用资源数量
     * 每个进程最大数量
     * 每个进程拥有资源数
     * 最大资源量
     * 请求资源的进程
     * 请求的资源
     */
    private final int[] available = new int[]{3,3,2};
    private final int [][] max = new int[][]{
            {7,5,3},
            {3,2,2},
            {9,0,2},
            {2,2,2},
            {4,3,3}
    };
    private final int[][] allocation = new int[][]{
            {0,1,0},
            {2,0,0},
            {3,0,2},
            {2,1,1},
            {0,0,2}};
    private final int[][] need = new int[][]{
            {7,4,3},
            {1,2,2},
            {6,0,0},
            {0,1,1},
            {4,3,1}};
    private int processNum;
    private final int[] request = new int[3];

    /**
     * 打印基础信息
     * T0时刻的资源分配表
     */
    void showData() {
        //展示数据输出每个进程的相关数
        System.out.print("进程号\tMax\t\t\tAll\t\t\tNeed\n");
        System.out.print("\t\tA  B  C\t\tA  B  C\t\tA  B  C\n");

        for(int i = 0;i< max.length;i++){
            System.out.print(i+"\t\t");

            for(int m = 0;m< max[0].length;m++) {
                System.out.print(max[i][m] + "  ");
            }
            System.out.print("\t");

            for(int m = 0;m<allocation[0].length;m++) {
                System.out.print(allocation[i][m] + "  ");
            }
            System.out.print("\t");

            for(int m = 0;m< need[0].length;m++) {
                System.out.print(need[i][m]+"  ");
            }
            System.out.println();
        }
    }

    /**
     * 打印空闲资源
     */
    void showAvailable() {
        System.out.print("可用资源为:\t");
        for (int i : available) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    /**
     * 输入请求的进程以及request向量
     */
    void inputRequest() {
        Scanner input = new Scanner(System.in);

        //输入进程号 0 - 4
        System.out.println("请输入要请求的进程号（0--4）：");
        processNum = input.nextInt();

        //输入请求的A B C资源的数目
        String[] source = new String[]{"A","B","C"};
        System.out.println("请输入请求的资源数目");
        for(int i = 0;i< request.length;i++) {
            System.out.println("请求的资源" + source[i] + "的数目：");
            request[i] = input.nextInt();
        }
    }

    /**
     * 根据请求分配资源
     */
    boolean allocate() {
        //判断是否满足条件
        for (int i = 0; i < need[0].length; i++) {
            if (request[i] > need[processNum][i]) {
                System.out.println("请求的资源数超过了所需要的最大值！");
                return false;
            }
        }

        for (int i = 0; i < available.length; i++) {
            if (request[i] > available[i]) {
                System.out.println("尚无足够资源分配,进程" + processNum + "进行等待");
                return false;
            }
        }

        //预分配内存
        for(int i = 0;i < request.length; i++) {
            available[i] = available[i] - request[i];
            allocation[processNum][i] = allocation[processNum][i] + request[i];
            need[processNum][i] = need[processNum][i] - request[i];
        }

        //若存在安全队列,则分配内存
        if (isSafe()) {
            System.out.println("能够安全分配");
            return true;
        } else {
            System.out.println("不能够安全分配");

            for(int i = 0;i< request.length;i++) {
                available[i] = available[i] + request[i];
                allocation[processNum][i] = allocation[processNum][i] - request[i];
                need[processNum][i] = need[processNum][i] + request[i];

            }
            return false;
        }
    }

    /**
     * @return 是否存在安全队列
     */
    private boolean isSafe() {
        //初始化work,可以工作的就是现在空闲的
        int[] work = new int[3];
        System.arraycopy(available, 0, work, 0, available.length);

        //初始化finish[]
        boolean[] finishes = new boolean[5];

        //循环查找安全队列
        for (int i = 0; i < max.length;) {
             //如果可以分配资源并使其执行完成，则置为true，并更新available
            if (!finishes[i] && need[i][0] <= work[0] && need[i][1] <= work[1] && need[i][2] <= work[2]) {
                System.out.println("进程" + i + "分配成功");

                for(int m = 0; m < allocation[0].length; m++) {
                    work[m] = work[m] + allocation[i][m];
                }

                finishes[i] = true;
                //找到后继续从头开始循环
                i=0;
            } else {
                i++;
            }
        }

        //判断是否存在安全序列
        for (boolean finish : finishes) {
            if (!finish) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Bank bk = new Bank();
        bk.showData();
        bk.showAvailable();
        bk.inputRequest();
        if (bk.allocate()) {
            System.out.println("分配成功");
        }
    }
}

