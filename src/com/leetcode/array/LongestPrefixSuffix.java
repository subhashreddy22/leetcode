package com.leetcode.array;

// https://leetcode.com/problems/longest-happy-prefix/discuss/2547127/Java-KMP-99-Faster-or-Time-Space-Complexity%3A-O(N)
// https://leetcode.com/problems/longest-happy-prefix/discuss/2534603/Java-or-KMP-Algorithm-or-LPS-or-Clean-Code
public class LongestPrefixSuffix {

    public static void main(String[] args) {
        System.out.println(longestPrefixSuffix("ababab"));
    }

    public static String longestPrefixSuffix(String s) {
        int[] lps = new int[s.length()];

        int len = 0;
        int i = 1;
        while(i < lps.length){
            if(s.charAt(i) == s.charAt(len)){
                lps[i] = len + 1;
                len++;
                i++;
            }else if(len == 0){
                lps[i] = 0;
                len = 0;
                i++;
            }else{
                len = lps[len - 1];
            }
        }

        int k = lps[s.length() - 1];

        return s.substring(0,k);

    }
}
