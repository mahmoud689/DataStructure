package com.queue.arrayImplementation;

import java.util.Stack;

public class QueueReverser {
    public static void reverseWithLimit(ArrayQueue queue, int limit) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < limit; i++) {
            stack.push(queue.dequeue());
        }
        while (!stack.isEmpty())
            queue.enqueue(stack.pop());
    }
}
