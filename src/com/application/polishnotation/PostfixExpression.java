package com.application.polishnotation;

import java.util.Arrays;
import java.util.Stack;

import static java.lang.Character.isDigit;

public class PostfixExpression {

    // For only single digit
    public static char[] infixToPostfix(char[] infix, char[] postfix) {
        Stack<Character> stack = new Stack();
        char current, top;
        for (int i = 0, j = 0; i < infix.length; i++) {
            current = infix[i];
            if (isDigit(current))
                postfix[j++] = current;
            else {
                if (!stack.isEmpty()) {
                    top = stack.peek();
                    while (!stack.isEmpty() && precedent(top, current)) {
                        postfix[j++] = stack.pop();
                        if (!stack.isEmpty()) {
                            top = stack.peek();
                        }
                    }
                }
                stack.push(current);
            }
        }
        while (!stack.isEmpty()) {
            postfix[infix.length - 1] = stack.pop();
        }
        return postfix;
    }

    private static boolean precedent(char op1, char op2) {
        if (op1 == '^') return true;
        if (op1 == '*' || op1 == '/') return (op2 != '^');
        if (op1 == '-' || op1 == '+') return (op2 != '^') && (op2 != '*') && (op2 != '/');
        return false;
    }

    public static void main(String[] args) {
        String infix = "156 + 21 * 13 ^ 40 / 58 + 6";
        Stack<String> strings = infixToPostfix(infix);
        char[] postfix = new char[60];
        infixToPostfix(infix.toCharArray(), postfix);
        System.out.println(Arrays.toString(postfix));
    }

    // For any digit
    private static Stack<String> infixToPostfix(String infinix) {
        String[] splitInfix = infinix.split(" ");
        Stack<String> postfix = new Stack<>();
        Stack<String> operators = new Stack<>();
        for (int i = 0; i < splitInfix.length; i++) {
            String current = splitInfix[i];
            switch (current) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                    checkPrecedentAndPostfixOperators(postfix, operators, current);
                    break;
                default:
                    postfix.push(current);
            }
        }
        while (!operators.isEmpty()) {
            postfix.push(operators.pop());
        }
        return postfix;
    }

    private static void checkPrecedentAndPostfixOperators(Stack<String> postfix, Stack<String> operators, String current) {
        if (!operators.isEmpty()) {
            String top = operators.peek();
            while (!operators.isEmpty() && precedent(top.charAt(0), current.charAt(0))) {
                postfix.push(operators.pop());
                if (!operators.isEmpty()) {
                    top = operators.peek();
                }
            }
        }
        operators.push(current);
    }
}
