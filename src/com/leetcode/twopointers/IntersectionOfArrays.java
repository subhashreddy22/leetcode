package com.leetcode.twopointers;

import java.util.Arrays;

// https://leetcode.com/problems/intersection-of-two-arrays-ii/
public class IntersectionOfArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 5, 2, 3};
        int[] nums2 = {2, 3, 3, 5, 1};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    static int[] intersect(int[] nums1, int[] nums2) {

        int[] result = new int[Math.min(nums1.length, nums2.length)];

        int i = 0, j = 0, k = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result[k] = nums1[i];
                i++;
                j++;
                k++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return Arrays.copyOfRange(result, 0, k);
    }
}
