package com.small.datastruct;

import java.util.Iterator;

/**
 * @author small
 */
public class LinkedStack<Item> implements Iterable<Item>{
    private Node first;
    private int n;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    /**
     * first && old first just like C of head pointer.
     * new Node()---> new = malloc(sizeof(Node)) 真实的创造一个实体
     * 然后就是头插法
     * @param item add element
     */
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<Item>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        LinkedStack<String> s = new LinkedStack<>();
        for (int i = 0; i < n; i++) {
            s.push(i + "");
            System.out.println("当前Stack元素的个数是" + s.size());
        }
        while (s.n > 0){
            System.out.println(s.pop() + "---" + s.isEmpty());
        }

    }
}
