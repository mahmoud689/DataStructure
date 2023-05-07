package com.queue.arrayImplementation;

import java.util.Arrays;
import java.util.Stack;

import static com.queue.arrayImplementation.QueueReverser.reverseWithLimit;

public class ArrayQueue {
    private int front;
    private int rear;
    private int size;
    private int[] items;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
        rear = -1;
    }

    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException();
        //to be circular
        rear = (rear + 1) % items.length;
        items[rear] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        int item = items[front];
        items[front] = 0;
        //to be circular
        front = (front + 1) % items.length;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public static void reverse(java.util.Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        reverseWithLimit(queue, 3);
        System.out.println(queue);
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
