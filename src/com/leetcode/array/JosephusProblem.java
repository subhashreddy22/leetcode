package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-the-winner-of-the-circular-game/
public class JosephusProblem {

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
    }

    static int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int current = 0;

        while (list.size() > 1) {
            current = (current + k - 1) % list.size();
            list.remove(current);
        }

        return list.get(0);
    }

}
