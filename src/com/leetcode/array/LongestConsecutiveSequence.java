package com.leetcode.array;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 1, 2, 3, 4 is the LCS
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 0, 1, 2, 3, 4, 5, 6, 7, 8 is the LCS
    }


    static int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numsSet = new HashSet<>();

        for (int num : nums) {
            numsSet.add(num);
        }

        int longestSeq = 1;

        for (int num : nums) {
            // ignore processing 100 if 99 is available, as 99 could be starting point of LCS. Same 99 can be ignored next if 98 is available
            if (!numsSet.contains(num - 1)) {
                int nextNum = num + 1;
                // iterate till next num is available in the set
                while (numsSet.contains(nextNum)) {
                    nextNum++;
                }
                int currentSeq = nextNum - num;
                longestSeq = Math.max(longestSeq, currentSeq);
            }
        }

        return longestSeq;
    }
}
