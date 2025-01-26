package com.leetcode.slidingwindow;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    static int maxProfit(int[] prices) {
        int lowestSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            lowestSoFar = Math.min(lowestSoFar, price);
            maxProfit = Math.max(maxProfit, price - lowestSoFar);
        }

        return maxProfit;
    }
}
