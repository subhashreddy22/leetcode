package com.leetcode.binarysearch;

public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1, 2, 6, 9, 10}, 7));
    }

    static int searchInsert(int[] nums, int target) {

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
