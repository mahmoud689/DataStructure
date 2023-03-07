package com.codewithmosh.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {

    private Node first;
    private Node last;

    private int size;

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addLast(int item) {
        Node node = new Node(item);
        if (isEmpty()) first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (isEmpty()) first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) first = last = null;
        else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last) first = last = null;
        else {
            Node previous = getPrevious();
            last = previous;
            last.next = null;
        }
        size--;
    }

    private Node getPrevious() {
        Node previous = first;
        while (previous != null) {
            if (previous.next == last) break;
            previous = previous.next;
        }
        return previous;
    }

    public int size() {
        return size;
    }

    public int indexOf(int item) {
        int index = 0;
        while (first.value == item) {
            if (first.next == null) return -1;
            index++;
            first = first.next;
        }
        return index;
    }

    public int indexOf2(int item) {
        int index = 0;
        while (first != null) {
            if (first.value == item) return index;
            first = first.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf2(item) != -1;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int[] toArray() {
        int[] array = new int[size];
        if (size == 0) return array;
        int i = 0;
        while (first != null) {
            array[i++] = first.value;
            first = first.next;
        }
        return array;
    }

    public class Node {
        private int value;
        private Node next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
        }
    }
}
