package com.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
        System.out.println(groupAnagrams(new String[] {""}));
        System.out.println(groupAnagrams(new String[] {"a"}));
        System.out.println(groupAnagrams(new String[] {"bdddddddddd","bbbbbbbbbbc"}));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> result = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];

            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                sb.append('#'); // this is needed for cases when key becomes which happens for example {"bdddddddddd","bbbbbbbbbbc"}
                sb.append(count[i]);
            }

            String key = sb.toString();

            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }

            result.get(key).add(str);
        }

        return new ArrayList<>(result.values());
    }
}
