package com.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is an extension to Two Sum Sorted.
 *
 * Expectation is to find all numbers such that i + j + k = 0 which is j + k = -i
 * Fix "i" and search for matching j and k in the sorted array coming after i
 */
// https://leetcode.com/problems/3sum/
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    static List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        // check only for num[i] <= 0 as it needs to be negative or zero (Atleast one of the triplets needs to be negative or zero for the triplet sum to be zero)
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // if the num is same as previous num then it doesn't need to be processed again
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total < 0) {
                    j++;
                } else if (total > 0) {
                    k--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    // if next jth element is same as previous skip it as it will result in same as before
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }

        return result;
    }
}
