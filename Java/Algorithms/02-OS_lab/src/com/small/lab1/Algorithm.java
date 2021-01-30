package com.small.lab1;

/**
 * @author small
 */
public class Algorithm{
    private Node pre = null;
    private Node prev = null;
    private Node min = null;

    private int num = 0;
    private int start = 0;
    private double nums = 0.0;
    private int count = 0;

    private static Create create = new Create();

    /**
     * 复制一份原本的单链表,原本的一份拷贝,不破坏原本的单链表
     * @param head 原本单链表的头结点
     * @return 复制的头结点
     */
    private static Node createHead(Node head){
        Node head2 = null;
        Node cur = head;
        while(cur!=null){
            head2 = create.createNode(head2,cur.name,cur.priority,cur.runtime,cur.arrivalTime,cur.starttime,cur.endtime,cur.turntime,cur.dturntime);
            cur = cur.nextNode;
        }
        return head2;
    }

    /**
     * 计算平均周转时间,并且初始化
     */
    private void endFun(){
        System.out.println("平均周转时间:" + (double) this.num / this.count + "平均带权周转时间:" + this.nums / this.count);
        this.start = 0;
        this.num = 0;
        this.nums = 0;
        this.count = 0;
    }

    /**
     * 计算显示
     * @return 头结点
     */
    private static Node toolMethod(Node min,Node prev,int start,Node head){
        min.starttime = start;
        min.endtime = min.starttime + min.runtime;
        min.turntime = min.endtime - min.arrivalTime;
        min.dturntime = (double) min.turntime / (double) min.runtime;
        System.out.println("名字:" + min.name + "、优先级:" + min.priority + "、运行时间:" + min.runtime + "、到达时间" + min.arrivalTime + "、开始时间:" + min.starttime + "、结束时间:" + min.endtime + "、周转时间:" + min.turntime + "、带权周转时间:" + min.dturntime);

        if (prev == null) {
            if (min.nextNode == null) {
                return null;
            }
            return min.nextNode;
        } else {
            prev.nextNode = min.nextNode;
        }

        return head;
    }

    private static Node findMin(Node head){
        Node cur = head;
        Node real = null;
        int minTime = cur.arrivalTime;

        while(cur!=null){
            if(cur.arrivalTime <= minTime){
                minTime = cur.arrivalTime;
                real = cur;
            }
            cur = cur.nextNode;
        }
        return real;
    }

    public void FCFS(Node head) {
        Node head2 = createHead(head);
        while (head2 != null) {
            min = null;
            pre = null;
            Node cur = head2;
            int minTime = cur.arrivalTime;

            //寻找最小结点
            //pre指向cur的前一个位置
            //prev指向min的前一个结点位置
            while (cur != null) {
                if (cur.arrivalTime <= minTime) {
                    minTime = cur.arrivalTime;
                    prev = pre;
                    min = cur;
                }
                pre = cur;
                cur = cur.nextNode;
            }

            if (min.arrivalTime > start) {
                start = min.arrivalTime;
            }
            head2 = toolMethod(min,prev,start,head2);
            start = start + min.runtime;
            num += min.turntime;
            nums += min.dturntime;
            count++;
        }
        this.endFun();
    }

    public void priority(Node head){
        Node head2 = createHead(head);
        while(head2 != null){
            min = null;
            pre = null;
            Node cur = head2;
            int minTime = 0;

            while(cur != null){
                if(cur.priority >= minTime && cur.arrivalTime <= start){
                    minTime = cur.priority;
                    prev = pre;
                    min = cur;
                }
                pre = cur;
                cur = cur.nextNode;
            }

            if(min == null){
                min = findMin(head2);
            }

            if(min.arrivalTime > start){
                start = min.arrivalTime;
            }

            head2 = toolMethod(min,prev,start,head2);
            start = start + min.runtime;
            num += min.turntime;
            nums += min.dturntime;
            count++;
        }
        this.endFun();
    }

    public void shortProcess(Node head){
        Node head2 = createHead(head);
        while(head2!=null){
            min = null;
            pre = null;
            Node cur = head2;
            int mintime = 1000;
            while(cur!=null){
                if(cur.runtime <= mintime && cur.arrivalTime <= start){
                    mintime = cur.runtime;
                    prev = pre;
                    min = cur;
                }
                pre = cur;
                cur = cur.nextNode;
            }
            if(min == null){
                min = findMin(head2);
            }

            if(min.arrivalTime > start){
                start = min.arrivalTime;
            }

            head2 = toolMethod(min,prev,start,head2);
            start = start + min.runtime;
            num += min.turntime;
            nums += min.dturntime;
            count++;
        }
        this.endFun();
    }

    private static double resRatio(Node node,int start){
        int waittime = start - node.arrivalTime;
        return (double)waittime/node.runtime;
    }
    public void hreponse(Node head){
        Node head2 = createHead(head);
        while(head2!=null){
            min = null;
            pre = null;
            Node cur = head2;
            double mintime = 0.0;
            while(cur!=null){
                double resratio = resRatio(cur,start);
                if(resratio >= mintime && cur.arrivalTime <= start){
                    mintime = resratio;
                    prev = pre;
                    min = cur;
                }
                pre = cur;
                cur = cur.nextNode;
            }
            if(min == null){
                min = findMin(head2);
            }
            if(min.arrivalTime > start){
                start = min.arrivalTime;
            }
            head2 = toolMethod(min,prev,start,head2);
            start = start + min.runtime;
            num += min.turntime;
            nums += min.dturntime;
            count++;
        }
        this.endFun();
    }

    public static Node queueHead(Node head){
        Node cur = head;
        Node nodemin = null;
        Node head2 = null;
        int min = 1000;
        int count = 0;
        while(cur!=null){
            count++;
            cur = cur.nextNode;
        }
        while(count!=0) {
            min = 1000;
            cur = head;
            while (cur != null) {
                if (cur.arrivalTime < min && cur.statu == 0) {
                    nodemin = cur;
                    min = cur.arrivalTime;
                }
                cur = cur.nextNode;
            }
            nodemin.statu = 1;
            count--;
            head2 = create.createNode(head2,nodemin.name,nodemin.priority,nodemin.runtime,nodemin.arrivalTime,nodemin.starttime,nodemin.endtime,nodemin.turntime,nodemin.dturntime);
        }
        return head2;
    }

    public static void insert(Node head,Node min){
        Node cur = head;
        Node pre = null;
        while(cur!=null){
            if(cur.arrivalTime > min.newarrival){
                pre.nextNode = min;
                min.nextNode = cur;
                return;
            }
            pre = cur;
            cur = cur.nextNode;
        }
        pre.nextNode = min;
        min.nextNode = cur;
    }

    public void roundrobin(Node head,int Rtime){
        Node newnode = null;
        Node head2 = queueHead(head);
        create.check(head2);
        System.out.println(head2.newruntime);
        System.out.println(head2.newarrival);
        while(head2!=null){
            min = head2;
            if(min.arrivalTime > start){
                start = min.arrivalTime;
            }
            if(min.newruntime > Rtime){
                min.newruntime -= Rtime;
                start += Rtime;
                min.newarrival += Rtime;
                newnode = new Node(min.name,min.priority,min.runtime,min.arrivalTime,min.starttime,min.endtime,min.turntime,min.dturntime);
                newnode.newarrival = min.newarrival;
                newnode.newruntime = min.newruntime;
                insert(head2,newnode);
                head2 = min.nextNode;
            }else{
                start += min.newruntime;
                min.endtime = start;
                min.turntime = min.endtime - min.arrivalTime;
                min.dturntime = (double) min.turntime / (double) min.runtime;
                head2 = min.nextNode;
                num += min.turntime;
                nums += min.dturntime;
                count++;
                System.out.println("名字:" + min.name + "、优先级:" + min.priority + "、运行时间:" + min.runtime + "、到达时间" + min.arrivalTime + "、开始时间:" + min.starttime + "、结束时间:" + min.endtime + "、周转时间:" + min.turntime + "、带权周转时间:" + min.dturntime);
            }
        }
        this.endFun();
    }
}


