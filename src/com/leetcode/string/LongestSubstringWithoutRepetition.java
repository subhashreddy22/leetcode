package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepetition {

    public static void main(String[] args) {
        LongestSubstringWithoutRepetition underTest = new LongestSubstringWithoutRepetition();
        System.out.println(underTest.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(underTest.alternateLengthOfLongestSubstring("abcabcbb"));
    }

    /* the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values,
    and keep two pointers which define the max substring. move the right pointer to scan through the string ,
    and meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to the
    right of the same character last found. Note that the two pointers can only move forward. */
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        int max = 0;

        for (int i = 0, j = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }

        return max;
    }


    public int alternateLengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        String str = "";
        int length = 0;

        for (Character c : s.toCharArray()) {
            String current = "" + c;

            if (str.contains(current)) {
                str = str.substring(str.indexOf(current) + 1);
            }

            str = str + c;

            length = Math.max(length, str.length());

        }

        return length;
    }
}
