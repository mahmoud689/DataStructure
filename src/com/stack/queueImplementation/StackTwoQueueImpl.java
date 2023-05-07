package com.stack.queueImplementation;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackTwoQueueImpl {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();


    public void push(int item) {
        if (queue1.isEmpty())
            queue1.add(item);
        else {
            while (!queue1.isEmpty())
                queue2.add(queue1.remove());

            queue1.add(item);
            while (!queue2.isEmpty())
                queue1.add(queue2.remove());

        }
    }

    public int pop() {
        return queue1.remove();
    }

    public int peek() {
        return queue1.peek();
    }

    public int size() {
        return queue1.size();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackTwoQueueImpl stackTwoQueue = new StackTwoQueueImpl();
        stackTwoQueue.push(10);
        stackTwoQueue.push(20);
        stackTwoQueue.push(30);
        int pop = stackTwoQueue.pop();
        int stackTop = stackTwoQueue.peek();
        System.out.println(pop);
        System.out.println(stackTop);
        System.out.println(stackTwoQueue.size());
        stackTwoQueue.pop();
        stackTwoQueue.pop();
        System.out.println(stackTwoQueue.isEmpty());
    }
}
