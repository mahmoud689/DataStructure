package com.queue.arrayImplementation;

public class PriorityQueue {
    private int size;
    private int[] items;

    public PriorityQueue(int capacity) {
        items = new int[capacity];
    }

    public void add(int item) {
        if (isFull())
            throw new IllegalStateException();

        int i = shiftItemsToInsert(item);
        items[i] = item;
        size++;
    }

    public int shiftItemsToInsert(int item) {
        int i;
        for (i = items.length - 1; i >= 0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else
                break;
        }
        return i + 1;
    }

    public boolean isFull() {
        return size == items.length;
    }

}
