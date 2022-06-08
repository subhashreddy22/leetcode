package com.leetcode.array;

// https://leetcode.com/problems/maximum-subarray/
public class KadanesAlgorithmMaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    static int maxSubArray(int[] nums) {
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for (int num : nums) {
            maxEndingHere += num;

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        return maxSoFar;
    }
}
