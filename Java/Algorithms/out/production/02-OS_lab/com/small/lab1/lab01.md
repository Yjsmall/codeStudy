~~~Java
package com.small.lab1;

/**
 * @author small
 */
public class Node {
    String name;
    int priority;
    int runtime;
    int arrivaltime;
    int starttime;
    int endtime;
    //周转时间
    int turntime;
    //带权周转时间
    double dturntime;
    Node nextnode;
    int statu;
    int newarrival;
    int newruntime;

    public Node(String name, int priority, int runtime, int arrivaltime, int starttime, int endtime, int turntime, double dturntime) {
        this.name = name;
        this.priority = priority;
        this.runtime = runtime;
        this.arrivalTime = arrivaltime;
        this.nextNode = null;
        this.starttime = starttime;
        this.endtime = endtime;
        this.turntime = turntime;
        this.dturntime = dturntime;
        this.newarrival = arrivaltime;
        this.newruntime = runtime;
    }

}
~~~

~~~Java
package com.small.lab1;

/**
 * @author small
 */
public class Create {
    /**
     * 尾插法
     * @param head
     * @param name
     * @param priority
     * @param runtime
     * @param arrivaltime
     * @param starttime
     * @param endtime
     * @param turntime
     * @param dturntime
     * @return
     */
    public Node createNode(Node head, String name, int priority, int runtime, int arrivaltime, int starttime, int endtime, int turntime, double dturntime) {

        if (head == null) {
            head = new Node(name, priority, runtime, arrivaltime, starttime, endtime, turntime, dturntime);
            return head;
        }

        Node cur = head;

        while (cur.nextNode != null) {
            cur = cur.nextNode;
        }
        cur.nextNode = new Node(name, priority, runtime, arrivaltime, starttime, endtime, turntime, dturntime);
        return head;
    }

    public void check(Node head) {
        if (head == null) {
            System.out.println("当前没有节点信息");
            return;
        }
        Node cur = head;
        while (cur != null) {
            System.out.println("名字:" + cur.name + "、优先级:" + cur.priority + "、运行时间:" + cur.runtime + "、到达时间" + cur.arrivalTime);
            cur = cur.nextNode;
        }
    }
}
~~~

~~~Java
package com.small.lab1;

/**
 * @author small
 */
public class Algorithm {
    private Node pre = null;
    private Node prev = null;
    private Node min = null;
    private int num = 0;
    private int start = 0;
    private double nums = 0.0;
    private int count = 0;
    private static Create create = new Create();

    private static Node CreateHead(Node head) {
        Node head2 = null;
        Node cur = head;
        while (cur != null) {
            head2 = create.createNode(head2, cur.name, cur.priority, cur.runtime, cur.arrivalTime, cur.starttime, cur.endtime, cur.turntime, cur.dturntime);
            cur = cur.nextNode;
        }
        return head2;
    }

    private void endFun() {
        System.out.println("平均周转时间:" + (double) this.num / this.count + "平均带权周转时间:" + this.nums / this.count);
        this.start = 0;
        this.num = 0;
        this.nums = 0;
        this.count = 0;
    }

    private static Node toolMethod(Node min, Node prev, int start, Node head) {
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

    private static Node findMin(Node head) {
        Node cur = head;
        Node real = null;
        int mintime = cur.arrivalTime;
        while (cur != null) {
            if (cur.arrivalTime <= mintime) {
                mintime = cur.arrivalTime;
                real = cur;
            }
            cur = cur.nextNode;
        }
        return real;
    }

    public void Fcfs(Node head) {
        Node head2 = CreateHead(head);
        while (head2 != null) {
            min = null;
            pre = null;
            Node cur = head2;
            int mintime = cur.arrivalTime;
            while (cur != null) {
                if (cur.arrivalTime <= mintime) {
                    mintime = cur.arrivalTime;
                    prev = pre;
                    min = cur;
                }
                pre = cur;
                cur = cur.nextNode;
            }
            if (min.arrivalTime > start) {
                start = min.arrivalTime;
            }
            head2 = toolMethod(min, prev, start, head2);
            start = start + min.runtime;
            num += min.turntime;
            nums += min.dturntime;
            count++;
        }
        this.endFun();
    }

    public void Priority(Node head) {
        Node head2 = CreateHead(head);
        while (head2 != null) {
            min = null;
            pre = null;
            Node cur = head2;
            int mintime = 0;
            while (cur != null) {
                if (cur.priority >= mintime && cur.arrivalTime <= start) {
                    mintime = cur.priority;
                    prev = pre;
                    min = cur;
                }
                pre = cur;
                cur = cur.nextNode;
            }
            if (min == null) {
                min = findMin(head2);
            }
            if (min.arrivalTime > start) {
                start = min.arrivalTime;
            }
            head2 = toolMethod(min, prev, start, head2);
            start = start + min.runtime;
            num += min.turntime;
            nums += min.dturntime;
            count++;
        }
        this.endFun();
    }

    public void ShortProcess(Node head) {
        Node head2 = CreateHead(head);
        while (head2 != null) {
            min = null;
            pre = null;
            Node cur = head2;
            int mintime = 1000;
            while (cur != null) {
                if (cur.runtime <= mintime && cur.arrivalTime <= start) {
                    mintime = cur.runtime;
                    prev = pre;
                    min = cur;
                }
                pre = cur;
                cur = cur.nextNode;
            }
            if (min == null) {
                min = findMin(head2);
            }
            if (min.arrivalTime > start) {
                start = min.arrivalTime;
            }
            head2 = toolMethod(min, prev, start, head2);
            start = start + min.runtime;
            num += min.turntime;
            nums += min.dturntime;
            count++;
        }
        this.endFun();
    }

    private static double resRatio(Node node, int start) {
        int waittime = start - node.arrivalTime;
        return (double) waittime / node.runtime;
    }

    public void Hreponse(Node head) {
        Node head2 = CreateHead(head);
        while (head2 != null) {
            min = null;
            pre = null;
            Node cur = head2;
            double mintime = 0.0;
            while (cur != null) {
                double resratio = resRatio(cur, start);
                if (resratio >= mintime && cur.arrivalTime <= start) {
                    mintime = resratio;
                    prev = pre;
                    min = cur;
                }
                pre = cur;
                cur = cur.nextNode;
            }
            if (min == null) {
                min = findMin(head2);
            }
            if (min.arrivalTime > start) {
                start = min.arrivalTime;
            }
            head2 = toolMethod(min, prev, start, head2);
            start = start + min.runtime;
            num += min.turntime;
            nums += min.dturntime;
            count++;
        }
        this.endFun();
    }

    public static Node QueueHead(Node head) {
        Node cur = head;
        Node nodemin = null;
        Node head2 = null;
        int min = 1000;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.nextNode;
        }
        while (count != 0) {
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
            head2 = create.createNode(head2, nodemin.name, nodemin.priority, nodemin.runtime, nodemin.arrivalTime, nodemin.starttime, nodemin.endtime, nodemin.turntime, nodemin.dturntime);
        }
        return head2;
    }

    public static void insert(Node head, Node min) {
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            if (cur.arrivalTime > min.newarrival) {
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

    public void Roundrobin(Node head, int Rtime) {
        Node newnode = null;
        Node head2 = queueHead(head);
        create.check(head2);
        System.out.println(head2.newruntime);
        System.out.println(head2.newarrival);
        while (head2 != null) {
            min = head2;
            if (min.arrivalTime > start) {
                start = min.arrivalTime;
            }
            if (min.newruntime > Rtime) {
                min.newruntime -= Rtime;
                start += Rtime;
                min.newarrival += Rtime;
                newnode = new Node(min.name, min.priority, min.runtime, min.arrivalTime, min.starttime, min.endtime, min.turntime, min.dturntime);
                newnode.newarrival = min.newarrival;
                newnode.newruntime = min.newruntime;
                insert(head2, newnode);
                head2 = min.nextNode;
            } else {
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
~~~
~~~Java
package com.small.lab1;


import java.util.Scanner;

/**
 * @author small
 */
public class Main {
    public static void dispatchMenu(Node head){
        Scanner sc = new Scanner(System.in);
        Algorithm al = new Algorithm();
        int count = 1;
        while(count == 1){
            System.out.println("请选择调度算法:");
            System.out.println("1.先来先服务算法");
            System.out.println("2.短作业优先算法");
            System.out.println("3.高优先级优先算法");
            System.out.println("4.高响应比优先算法");
            System.out.println("5.时间片轮转算法");
            System.out.println("0.退出");
            int num = sc.nextInt();
            switch(num){
                case 1:al.Fcfs(head);
                    break;
                case 2:al.ShortProcess(head);
                    break;
                case 3:al.Priority(head);
                    break;
                case 4:al.Hreponse(head);
                    break;
                case 5:al.Roundrobin(head,1);
                    break;
                case 0:count = 0;
                    break;
                default:System.out.println("输入错误请重新输入");
            }
        }
    }

    public static void mainMenu(){
        Create create = new Create();
        Node head = null;

        Scanner sc = new Scanner(System.in);

        int count1 = 1;
        while(count1 == 1){
            System.out.println("请选择你需要的服务:");
            System.out.println("1.添加新进程");
            System.out.println("2.使用调度算法进行排序");
            System.out.println("3.查看当前进程信息");
            System.out.println("0.退出");
            int num = sc.nextInt();
            switch(num){
                case 1:
                    String name;
                    int priority;
                    int runtime;
                    int arrivaltime;
                    System.out.println("请输入进程名字:");
                    name = sc.next();
                    System.out.println("请输入进程优先级:");
                    priority = sc.nextInt();
                    System.out.println("请输入进行运行时间:");
                    runtime = sc.nextInt();
                    System.out.println("请输入进程到达时间:");
                    arrivaltime = sc.nextInt();
                    head = create.createNode(head,name,priority, runtime,arrivaltime,0,0,0,0);
                    break;

                case 2:
                    Main.dispatchMenu(head);
                    break;

                case 3:create.check(head);
                    break;

                case 0:count1 = 0;
                    break;

                default:System.out.println("输入错误请重新输入");
            }
        }
    }

    public static void main(String[] args) {
        Main.mainMenu();
    }
}
~~~