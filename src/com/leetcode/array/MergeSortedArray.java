package com.leetcode.array;

import java.util.Arrays;

// https://leetcode.com/problems/merge-sorted-array/
// Sol: https://leetcode.com/problems/merge-sorted-array/discuss/29704/My-clean-java-solution
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    static  void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        // leftover elements in nums2. No need to do it for nums1 as we are adding these to nums1 which already has them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
