package com.leetcode.binarysearch;

import java.util.Arrays;

// https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
// Sol: https://leetcode.com/problems/find-the-distance-value-between-two-arrays/discuss/609472/Java-Binary-search-with-explanation
public class DistanceValueBetweenTwoArrays {

    public static void main(String[] args) {
        System.out.println(findTheDistanceValue(new int[] {4, 5, 8}, new int[] {10, 9, 1, 8}, 2));
    }

    static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int num : arr1) {
            if (notInRange(arr2, num - d, num + d)) {
                count++;
            }
        }
        return count;
    }

    static boolean notInRange(int[] arr, int from, int to) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= from && arr[mid] <= to) {
                return false;
            } else if (arr[mid] < from) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return true;
    }
}


