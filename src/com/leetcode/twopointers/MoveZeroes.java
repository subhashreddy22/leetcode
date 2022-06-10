package com.leetcode.twopointers;

import java.util.Arrays;

// https://leetcode.com/problems/move-zeroes/
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void moveZeroes(int[] nums) {

        int zeroesCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroesCount++;
            } else if (zeroesCount > 0) {
                nums[i - zeroesCount] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
