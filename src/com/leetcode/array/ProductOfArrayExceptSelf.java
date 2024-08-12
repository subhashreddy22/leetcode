package com.leetcode.array;

import java.util.Arrays;

// https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[] {-1, 1, 0, -3, 3})));
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int left = 1, right = 1;

        for (int i = 0; i < result.length; i++) {
            result[i] = left;
            left *= nums[i];
        }

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }
}
