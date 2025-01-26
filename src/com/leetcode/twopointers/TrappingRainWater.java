package com.leetcode.twopointers;

// https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));

        System.out.println(trapWithTwoPointers(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trapWithTwoPointers(new int[]{4, 2, 0, 3, 2, 5}));
    }

    static int trap(int[] height) {

        int n = height.length;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int trappedWater = 0;

        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(left[i], right[i]) - height[i];
        }

        return trappedWater;
    }

    // https://www.enjoyalgorithms.com/blog/trapping-rain-water
    static int trapWithTwoPointers(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;

        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    trappedWater += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    trappedWater += maxRight - height[right];
                }
                right--;
            }
        }

        return trappedWater;
    }
}
