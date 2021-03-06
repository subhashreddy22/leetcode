package com.leetcode.binarysearch;

// https://leetcode.com/problems/valid-perfect-square/
public class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(25));
    }

    static boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                l = (int) mid + 1;
            } else {
                r = (int) mid - 1;
            }
        }
        return false;
    }
}
