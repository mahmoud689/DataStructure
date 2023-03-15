package com.stack.linkedImplementation;

import com.codewithmosh.linkedlist.LinkedList;

public class Stack {

    private int top;
    private LinkedList linkedList;

    public void push(int element) {
        linkedList.addLast(element);
    }


    public int pop() {
        LinkedList.Node last = linkedList.getLast();
        linkedList.removeLast();
        return last.getValue();
    }
}
