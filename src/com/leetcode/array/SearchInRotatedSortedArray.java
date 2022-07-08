package com.leetcode.array;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[] {6, 7, 8 ,9, 1, 2, 3, 4, 5}, 3));
    }

    static int search(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[l] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] <= nums[r]) {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        
        return -1;
    }
}