package com.small.process;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author small
 */
public class ProcessMenu {
    /**
     * 存放所有进程
     * 存放按指定调度算法排序后的进程
     * 存放已经进入队列的进程
     * 当前应执行进程
     */
    ArrayList<JCB> jcb;
    ArrayList<JCB> newJcb;
    LinkedList<JCB> link;
    JCB newProcess;

    /**
     * 初始化,加入作业
     */
    public void init() {
        jcb = new ArrayList<>();
        link = new LinkedList<>();
        newJcb = new ArrayList<>();
        JCB p1 = new JCB("1", 0, 4,3);
        JCB p2 = new JCB("2", 1, 3,2);
        JCB p3 = new JCB("3", 2, 5,3);
        JCB p4 = new JCB("4", 3, 2,1);
        JCB p5 = new JCB("5", 4, 4,5);
        jcb.add(p1);jcb.add(p2);jcb.add(p3);jcb.add(p4);jcb.add(p5);
        //先将jcb排序，便于下面的算法实现，就不需要再定义一个标识进程是否已到达的boolean,即无需每次都从头开始扫描jcb容器，
        //而是用一个K记录下当前已经扫描到的位置，一次遍历即可，提高了算法效率。
        jcb.sort(new CompareAT_ST());
    }

    /**
     * 先来先服务算法
     */
    public void FCFS(){
        //调用内部类
        ProcessQueue pq=new ProcessQueue();
        //让最先到达的进程先入队
        pq.enqueueLast();
        System.out.println("*****************************************************");

        //当前队列不为空
        while(!link.isEmpty()) {
            //打印当前队列中的进程
            pq.displayQueue();
            //出队，一次一个
            pq.dequeue();
            //已到达的进程入队
            pq.enqueueLast();
        }
    }

    /**
     * 短作业算法
     */
    public void SJF() {
        ProcessQueue pq=new ProcessQueue();
        pq.enqueueLast();
        System.out.println("*****************************************************");
        while(!link.isEmpty()) {
            pq.displayQueue();
            pq.dequeue();
            pq.enqueueLast();
            //队列中的进程还需按服务时间长度进行排序
            link.sort(new CompareST());
        }
    }

    /**
     * 时间片轮转法
     */
    public void RR() {
        ProcessQueue pq=new ProcessQueue();
        pq.enqueueLast();
        System.out.println("*****************************************************");
        while(!link.isEmpty()) {
            //打印当前队列中的进程
            pq.displayQueue();
            //出队，一次一个，因为上一轮出的得让刚到达的进程先进队列，所以没办法，进队操作只能也放在这个函数里了
            pq.dequeue(4);
        }
    }

    /**
     * 高响应比优先调度算法
     */
    public void HRN() {
        ProcessQueue pq=new ProcessQueue();
        pq.enqueueLast();
        System.out.println("*****************************************************");
        while(!link.isEmpty()) {
            pq.displayQueue();
            pq.dequeue();
            pq.enqueueLast();
            //队列中的进程还需按响应比进行排序
            link.sort(new ComparePriority());
        }
    }

    class ProcessQueue{
        int k = 0;// jcb中的进程遍历时的下标
        int nowTime = 0;// 当前时间
        double sliceTime;//轮转调度时间片
        int i=0;//记录当前出入队列的次数
        
        //进程首次入队，可一次进多个,从队尾进入
        public void enqueueLast() {
            //当遍历完jcb中的所有进程时结束
            while (k < jcb.size()) {
                //已经到达的进程按到达时间先后进入队列
                if (jcb.get(k).arriveTime <= nowTime) {
                    link.addLast(jcb.get(k));
                    k++;
                } else {
                    //如果该进程还未入队，即先结束遍历，保留当前下标k值,不能k--；
                    break;
                }
            }
        }

        public void enqueueFirst() {//进程首次入队，可一次进多个,从队首进入
            while (k < jcb.size()) {//当遍历完jcb中的所有进程时结束
                if (jcb.get(k).arriveTime <= nowTime) {//已经到达的进程按到达时间先后进入队列
                    link.addFirst(jcb.get(k));
                    k++;
                } else {
                    break;//如果该进程还未入队，即先结束遍历，保留当前下标k值，注意：此处不要k--；
                }
            }
        }

        /**
         * 进程出队，一次只出一个
         */
        public void dequeue() {
            //移除队列的队首元素并且返回该对象元素
            newProcess = link.removeFirst();
            //计算开始--结束--周转--平均周转
            newProcess.beginTime = nowTime;
            newProcess.finshTime = newProcess.beginTime + newProcess.serveTime;
            newProcess.roundTime = newProcess.finshTime - newProcess.arriveTime;
            newProcess.aveRoundTime = (double) newProcess.roundTime / newProcess.serveTime;
            //获得结束时间，即当前时间，方便判断剩下的进程是否已到达
            nowTime = newProcess.finshTime;
            //经处理过数据后加入newJcb容器
            newJcb.add(newProcess);

            for (JCB value : link) {
                //所有进入等待队列的进程等待时间+1,此处只为最高响应比算法所用
                value.waitTime++;
            }
        }

        //重载dequeue方法，实现轮转调度算法的出队
        public void dequeue(double sliceTime) {
            //移除队列的队首元素并且返回该对象元素
            newProcess = link.removeFirst();

            //轮转调度进程可能会多次反复进出队列，不像FCFS和SJF的进程只会进出一次，
            // 所以计算开始时间可以设个标志位，让每个进程在第一次执行时记录一遍即可
            if(!newProcess.firstTimeTag) {
                //进程开始执行的时间
                newProcess.beginTime = nowTime;
                //计算第一次即可，下次无需更新计算
                newProcess.firstTimeTag = true;
            }
            //每次出队，用时一个时间片，更新当前时间
            nowTime += sliceTime;
            //更新当前出队列的进程已服务时间
            newProcess.clock += sliceTime;

            if(newProcess.clock >= newProcess.serveTime) {
                //计算该进程完成--周转时间--平均周转时间
                newProcess.finshTime = nowTime;
                newProcess.roundTime = newProcess.finshTime - newProcess.arriveTime;
                newProcess.aveRoundTime = (double) newProcess.roundTime / newProcess.serveTime;
                //经处理过数据后加入new_jcb容器
                newJcb.add(newProcess);
                //已到达的进程先入队
                enqueueFirst();
            } else {
                //已到达的进程先入队
                enqueueFirst();
                //上一轮出的再紧接着进入队尾
                link.addLast(newProcess);
            }
        }

        //队列中等候的进程
        public void displayQueue(){
            i++;
            System.out.println("第"+i+"次队列中排队的进程："+link);
        }
    }

    public void printProcess() {
        System.out.println("进程名\t到达时间\t服务时间\t开始时间\t完成时间\t周转时间\t带权周转时间");
        for (JCB value : newJcb) {
            System.out.println("P" + value.name + "\t\t" + value.arriveTime + "\t\t" +
                    value.serveTime + "\t\t" + value.beginTime + "\t\t" + value.finshTime +
                    "\t\t" + value.roundTime + "\t\t" + value.aveRoundTime);
        }
        newJcb.clear();//清空new_jcb容器内的内容，方便存储各种算法的结果并展示
    }

    public static void main(String[] args) {
        ProcessMenu pm = new ProcessMenu();
        pm.init();
        pm.RR();pm.printProcess();

    }
}

/**
 * 按照服务时间升序排列
 */
class CompareST implements Comparator<JCB> {// 按服务时间升序
    @Override
    public int compare(JCB arg0, JCB arg1) {
        return arg0.serveTime - arg1.serveTime;
    }
}

/**
 * 到达时间升序排列,若相同,服务时间升序
 */
class CompareAT_ST implements Comparator<JCB> {
    @Override
    public int compare(JCB o1, JCB o2) {
        int a = o1.arriveTime - o2.arriveTime;
        if (a > 0) {
            return 1;
        } else if (a == 0) {
            return o1.serveTime > o2.serveTime ? 1 : -1;
        } else {
            return -1;
        }
    }
}

/**
 * 按照响应比升序
 */
class ComparePriority implements Comparator<JCB>{
    @Override
    public int compare(JCB o1, JCB o2) {
        double r1=(double)o1.waitTime/o1.serveTime;
        double r2=(double)o2.waitTime/o2.serveTime;
        return r1 > r2 ? 1 : -1;
    }

}
