package com.leetcode.binarysearch;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class NextGreatestLetter {

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[] {'d', 'f', 'j'}, 'e'));
    }

    static char nextGreatestLetter(char[] letters, char target) {

        if (target > letters[letters.length - 1]) {
            return letters[0];
        }

        int l = 0, r = letters.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return letters[l % letters.length];
    }
}
