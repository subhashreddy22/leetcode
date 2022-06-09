package com.leetcode.binarysearch;

// https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[] {0 ,1, 3, 5, 1, 0}));
    }

    static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1, mid = 0;

        while (l <= r) {
            mid = l + (r - l) / 2;

            if ((mid == 0 || arr[mid - 1] < arr[mid]) && (mid == n - 1 || arr[mid + 1] < arr[mid])) {
                return mid;
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return mid;
    }
}
