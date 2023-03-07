package com.codewithmosh.linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(5);
        linkedList.addLast(30);
        linkedList.addLast(40);
        int[] array = linkedList.toArray();
        int size = linkedList.size();
        boolean index = linkedList.contains(20);
        System.out.println(index);
    }
}
