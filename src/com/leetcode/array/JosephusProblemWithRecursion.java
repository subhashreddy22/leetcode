package com.leetcode.array;

// https://leetcode.com/problems/find-the-winner-of-the-circular-game/
public class JosephusProblemWithRecursion {

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
    }

    static int findTheWinner(int n, int k) {
        if (n == 1) {
            return 1;
        }

        return (findTheWinner(n -1, k) + k - 1) % n + 1;
    }

}
