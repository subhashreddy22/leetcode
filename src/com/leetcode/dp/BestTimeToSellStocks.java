package com.leetcode.dp;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToSellStocks {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
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
