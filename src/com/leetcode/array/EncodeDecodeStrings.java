package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/encode-and-decode-strings/
public class EncodeDecodeStrings {

    public static void main(String[] args) {
        String encodedString = encode(List.of("we","say",":","yes"));
        System.out.println(encodedString);
        System.out.println(decode(encodedString));
    }

    private static String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }

    private static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;
            list.add(str.substring(j + 1, i));
        }
        return list;
    }
}
