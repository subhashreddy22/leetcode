package com.leetcode.dp;

// https://leetcode.com/problems/delete-and-earn/
// Sol: https://leetcode.com/problems/delete-and-earn/discuss/109895/JavaC%2B%2B-Clean-Code-with-Explanation
public class DeleteAndEarn {

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[] {3, 4 ,2}));
    }

    static int deleteAndEarn(int[] nums) {
        // store all the same elements in their respective buckets by adding them up
        // Length is set to 10001 as the constraint for max value in nums in 10000
        int[] buckets = new int[10001];
        for (int num : nums) {
            buckets[num] += num;
        }

        int[] dp = new int[100001];
        dp[0] = buckets[0];
        dp[1] = buckets[1];

        // similar to house robber
        for (int i = 2; i < buckets.length; i++) {
            dp[i] = Math.max(buckets[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[10000];
    }
}
