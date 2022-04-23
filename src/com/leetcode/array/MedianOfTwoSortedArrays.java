package com.leetcode.array;


/*
 	Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

	Example 1:
	
	Input: nums1 = [1,3], nums2 = [2]
	Output: 2.00000
	Explanation: merged array = [1,2,3] and median is 2.
	Example 2:
	
	Input: nums1 = [1,2], nums2 = [3,4]
	Output: 2.50000
	Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
	Example 3:
	
	Input: nums1 = [0,0], nums2 = [0,0]
	Output: 0.00000
	Example 4:
	
	Input: nums1 = [], nums2 = [1]
	Output: 1.00000
	Example 5:
	
	Input: nums1 = [2], nums2 = []
	Output: 2.00000
	 
	
	Constraints:
	
	nums1.length == m
	nums2.length == n
	0 <= m <= 1000
	0 <= n <= 1000
	1 <= m + n <= 2000
	-106 <= nums1[i], nums2[i] <= 106
 */
// https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/
public class MedianOfTwoSortedArrays {
	
	public static void main(String[] args) {
		MedianOfTwoSortedArrays instance = new MedianOfTwoSortedArrays();
		System.out.println(instance.findMedianSortedArrays(new int[] {1, 3}, new int[] {2, 4}));
	}
	
	
	/**
	 * 
	 * Time Complexity - O(m + n) where m, n are lengths of given two arrays
	 * Space Complexity - O(1)
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		double m1 = 0, m2 = 0;
		int i = 0;
		int j = 0;

		if ((nums1.length + nums2.length) % 2 == 1) {
			for (int k = 0; k <= (nums1.length + nums2.length) / 2; k++) {
				if (i < nums1.length && j < nums2.length) {
					m1 = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
				} else if (i < nums1.length) {
					m1 = nums1[i++];
				} else {
					m1 = nums2[j++];
				}
			}

			return m1;
		} else {
			for (int k = 0; k <= (nums1.length + nums2.length) / 2; k++) {
				m2 = m1;
				if (i < nums1.length && j < nums2.length) {
					m1 = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
				} else if (i < nums1.length) {
					m1 = nums1[i++];
				} else {
					m1 = nums2[j++];
				}
			}

			return (m1 + m2) / 2;
		}
	}
}