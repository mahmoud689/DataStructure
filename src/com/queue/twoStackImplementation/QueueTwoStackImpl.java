package com.queue.twoStackImplementation;

import java.util.Stack;

public class QueueTwoStackImpl {
    private java.util.Stack<Integer> stack1 = new Stack<>();
    private java.util.Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        return stack2.pop();
    }

    //for test only
    public static void main(String[] args) {
        QueueTwoStackImpl queueTwoStack = new QueueTwoStackImpl();
        queueTwoStack.enqueue(10);
        queueTwoStack.enqueue(20);
        queueTwoStack.enqueue(30);
        int first = queueTwoStack.dequeue();
        System.out.println(first);
    }
}
