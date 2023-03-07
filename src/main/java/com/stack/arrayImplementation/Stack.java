package com.stack.arrayImplementation;

import java.util.Arrays;
import java.util.List;

public class Stack {
    private int top;
    int[] entry = new int[5];

    private final List<Character> rightBrackets = Arrays.asList(')', '>', '}', ']');

    private final List<Character> leftBrackets = Arrays.asList('(', '<', '{', '[');

    public void push(int element) {
        if (top == entry.length)
            throw new StackOverflowError();

        entry[top++] = element;
    }

    public int pop() {
        if (top == 0)
            throw new IllegalStateException();

        return entry[--top] = 0;
    }

    public int peek() {
        if (top == 0)
            throw new IllegalStateException();

        return entry[top - 1];
    }

    public boolean isEmpty() {
        if (top == 0)
            return true;

        return false;
    }

    public boolean isFull() {
        if (top == entry.length)
            return true;

        return false;
    }

    public int minStack() {
        if (isEmpty())
            throw new IllegalStateException();

        int min = entry[top - 1];

        for (int i = top - 1; i >= 0; i--) {
            if (entry[i] < min)
                min = entry[i];
        }
        return min;
    }

    @Override
    public String toString() {
        int[] copy = Arrays.copyOfRange(entry, 0, top);
        return Arrays.toString(copy);
    }

    public boolean isBalanced(String str) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : str.toCharArray()) {
            if (isLeftBracket(c))
                stack.push(c);
            if (isRightBracket(c)) {
                if (stack.isEmpty()) return false;
                Character top = stack.pop();
                if (!bracketMatch(top, c))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean bracketMatch(char top, char right) {
        return leftBrackets.indexOf(top) == rightBrackets.indexOf(right);
    }

    private boolean isLeftBracket(char c) {
        return leftBrackets.contains(c);
    }

    private boolean isRightBracket(char c) {
        return rightBrackets.contains(c);
    }
}
