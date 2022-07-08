package com.leetcode.array;

public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {6, 7, 8 ,9, 1, 2, 3, 4, 5}));
    }

    static int findMin(int[] nums) {
        
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            
            int mid = l+ (r - l) / 2;
            
            if (mid > 0 && (nums[mid] < nums[mid - 1])) {
                return nums[mid];
            } 
            
            if (nums[l] <= nums[mid] && nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return nums[l];
    }
}