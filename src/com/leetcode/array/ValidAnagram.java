package com.leetcode.array;

// https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("abc", "cab"));
        System.out.println(isAnagram("car", "rat"));
    }

    private static boolean isAnagram(String s, String t) {

        if (s == null && t == null) {
            return true;
        }

        if (s == null) {
            return false;
        }

        if (t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] buffer = new int[26];

        for (int i = 0; i < s.length(); i++) {
            buffer[s.charAt(i) - 'a']++;
            buffer[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (buffer[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
