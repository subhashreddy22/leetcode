package com.leetcode.dp;

// https://leetcode.com/problems/n-th-tribonacci-number/
public class TribonacciNumber {

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
    }

    static int tribonacci(int n) {

        if (n < 2) {
            return n;
        }

        if (n == 2) {
            return 1;
        }

        int[] trib = new int[n + 1];
        trib[0] = 0;
        trib[1] = 1;
        trib[2] = 1;

        for (int i = 3; i <= n; i++) {
            trib[i] = trib[i - 3] + trib[i - 2] + trib[i - 1];
        }

        return trib[n];
    }
}
