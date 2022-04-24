package com.leetcode.string;

import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        int end = Math.min(strs[0].length(), strs[strs.length - 1].length());

        int i = 0;

        while (i < end && (strs[0].charAt(i) == strs[strs.length - 1].charAt(i))) {
            i++;
        }

        return strs[0].substring(0, i);
    }
}
