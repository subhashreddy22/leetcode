package com.leetcode.twopointers;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {1, 3, 5, 6, 7, 8}, 10)));
    }

    static int[] twoSum(int[] numbers, int target) {

        int l = 0, r = numbers.length - 1;
        int[] result = new int[2];

        // modification of binary search
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                result[0] = l;
                result[1] = r;
                return result;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }

        return result;
    }
}
