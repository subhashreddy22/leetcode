package com.leetcode.misc;

/*
Geek is extremely punctual but today even he is not feeling like doing his homework assignment. He must start doing it immediately in order to meet the deadline. For the assignment, Geek needs to type a string s.
To reduce his workload, he has decided to perform one of the following two operations till he gets the string.

Append a character at the end of the string.
Append the string formed thus far to the end of the string. (This can not be done more than once.)
Help Geek find the minimum operations required to type the given string.

Example 1:
Input:
s = abcabca
Output: 5
Explanation: a -> ab -> abc -> abcabc
-> abcabca

Example 2:
Input:
s = abcdefgh
Output: 8
Explanation: a -> ab -> abc -> abcd
-> abcde -> abcdef -> abcdefg -> abcdefgh

Solution:
Intuition:
Since second operation can be done at most once, we will try and use it wisely. So we have to make the biggest possible string by this operation.
To perform the second operation, take the righmost index i such that s[0...i] = s[i+1 .... 2i].

Implementation:
We will have to choose the maximum length of substring where we can apply the 2nd operation.

Follow the below steps:
Steps:
1. Run a loop from the mid(i = n/2) of the array to staring index of the array in backward direction.
2. For each iteration, we will check if the substring from index 0 to i is equal to the substring of same length starting form i+1.
3. For any iteration, if two strings be same, there we will do the second operation. That means we will do first operation till i,
then we will do the second operation. To do the second operation, we will add same length of substring starting from i+1.
4. As second operation can not be done more than once, we will do first operation for the remaining elements.
Complexity:

Time Complexity: O(N2)
Space Complexity: O(1)
 */
public class TypeIt {
    public static void main(String[] args) {
        System.out.println(minOperation("abcabc"));
        System.out.println(minOperation("abcdef"));
    }

    static int minOperation(String s) {

        int n = s.length();
        for (int i = n / 2 - 1; i >= 0; --i)
            if (s.substring(0, i + 1).equals(s.substring(i + 1, 2 * (i + 1))))
                return (i + 1) + 1 + (n - 2 * (i + 1));

        return n;
    }
}

