package com.leetcode.binarysearch;

public class SquareRoot {

    public static void main(String[] args) {
        System.out.println(mySqrt(16));
    }

    static int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        int l = 1, r = x / 2;
        int sqrt = -1;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                sqrt = (int) mid;
                l = (int) mid + 1;
            } else {
                r = (int) mid - 1;
            }
        }

        return sqrt;
    }
}
