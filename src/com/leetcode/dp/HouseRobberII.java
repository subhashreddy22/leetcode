package com.leetcode.dp;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber-ii/
public class HouseRobberII {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));
    }

    /**
     * Since House[1] and House[n] are adjacent, they cannot be robbed together.
     * Therefore, the problem becomes to rob either House[1]-House[n-1] or House[2]-House[n],
     * depending on which choice offers more money. Now the problem has degenerated to the House Robber,
     * which is already been solved.
     *
     * @param nums
     * @return
     */
    static int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robHouse(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                robHouse(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    static int robHouse(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length];
    }
}
