package com.small.lab1;

/**
 * @author small
 */
public class Create {
    /**
     * 尾插法
     * @return 头结点
     */
    public Node createNode(Node head, String name, int priority, int runtime, int arrivaltime, int starttime, int endtime, int turntime, double dturntime){

        if(head == null){
            head = new Node(name,priority,runtime,arrivaltime,starttime,endtime,turntime,dturntime);
            return head;
        }

        Node cur = head;

        while(cur.nextNode != null) {
            cur = cur.nextNode;
        }
        cur.nextNode = new Node(name,priority,runtime,arrivaltime,starttime,endtime,turntime,dturntime);
        return head;
    }

    public void check(Node head){
        if(head == null){
            System.out.println("当前没有节点信息");
            return;
        }
        Node cur = head;
        while(cur!=null){
            System.out.println("名字:"+cur.name+"、优先级:"+cur.priority+"、运行时间:"+cur.runtime+"、到达时间"+cur.arrivalTime);
            cur = cur.nextNode;
        }
    }
}

