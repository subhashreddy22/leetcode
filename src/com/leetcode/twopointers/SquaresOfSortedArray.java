package com.leetcode.twopointers;

import java.util.Arrays;

// https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int[] result = sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(result));
    }

    static int[] sortedSquares(int[] nums) {

        int i = 0, j = nums.length - 1;
        int[] result = new int[nums.length];

        for (int k = nums.length - 1; k >= 0; k--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[k] = nums[i] * nums[i];
                i++;
            } else {
                result[k] = nums[j] * nums[j];
                j--;
            }
        }

        return result;
    }
}
