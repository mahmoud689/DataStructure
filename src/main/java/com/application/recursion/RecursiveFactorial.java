package com.application.recursion;

public class RecursiveFactorial {
    private static int factorial(int n) {
        return (n <= 1) ? 1 : n * factorial(n - 1);
//        if (n <= 1)
//            return 1;
//        else
//            return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int factorial = factorial(4);
        System.out.println(factorial);
    }
}
