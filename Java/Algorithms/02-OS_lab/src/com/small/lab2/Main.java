package com.small.lab2;

import java.util.Scanner;

/**
 * @author small
 */
public class Main {

    public static void main(String[] args) {
        Memory memory;
        Scanner in = new Scanner(System.in);
        System.out.print("请初始化内存大小:");
        int size = in.nextInt();
        memory = new Memory(size);
        memory.showZones();
        boolean star = true;

        while (star){
            System.out.println("0.退出 1.申请空间  2.回收空间  3.显示分区状况 ");
            System.out.print("请选择指令:");
            size = in.nextInt();
            switch (size) {
                case 1:
                    System.out.print("请输入需要申请的空间大小:");
                    size = in.nextInt();
                    memory.allocation(size);
                    break;
                case 2:
                    System.out.print("请输入需要回收的分区号:");
                    size = in.nextInt();
                    memory.collection(size);
                    break;
                case 3:
                    memory.showZones();
                    break;
                case 0:
                    star = false;
                    break;
                default:
                    System.out.println("请重新选择!");
            }
        }
    }
}

