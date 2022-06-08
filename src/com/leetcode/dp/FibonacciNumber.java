package com.leetcode.dp;

// https://leetcode.com/problems/fibonacci-number/
public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fib(7));
        System.out.println(fibWithDp(7));
    }

    static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static int fibWithDp(int n) {
        if (n < 2) {
            return n;
        }

        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i- 2];
        }

        return fib[n];
    }
}
