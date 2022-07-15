package pers.hugh.dp;

import java.util.LinkedList;

/**
 * @author dingxiuzheng
 */
public class BestTimeToBuyAndSellStockIV {

    //188. Best Time to Buy and Sell Stock IV
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/


    private LinkedList<Integer> track;
    private int profit;

    //backtrack TLE
    public int maxProfit(int k, int[] prices) {
        track = new LinkedList<>();
        profit = 0;
        backtrack(k, prices, 0);
        return profit;
    }

    public void backtrack(int k, int[] prices, int i) {
        if (track.size() % 2 == 0) {
            profit = Math.max(profit, getProfit(track));
            if (track.size() / 2 == k) {
                return;
            }
        }
        if (i >= prices.length) {
            return;
        }

        //买或者卖
        track.add(prices[i]);
        backtrack(k, prices, i + 1);
        track.removeLast();
        //不买且不卖
        backtrack(k, prices, i + 1);
    }

    private int getProfit(LinkedList<Integer> track) {
        int profit = 0;
        for (int i = 0; i < track.size(); i = i + 2) {
            profit += track.get(i + 1) - track.get(i);
        }
        return profit;
    }


    //dp
    //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
    //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])

    //dp[-1][...][0] = 0
    //dp[-1][...][1] = 负无穷，初始阶段和dp[-1][...][0]比较，不能选择此种情况，所以设置负无穷
    //dp[...][0][0] = 0
    //dp[...][0][1] = 负无穷，初始阶段和dp[...][0][0]比较，不能选择此种情况，所以设置负无穷
    //
    //i从-1算更好算，当然也可以
    //dp[-1][...][0] = dp[...][0][0] = 0
    //dp[-1][...][1] = dp[...][0][1] = 负无穷

    public int maxProfit2(int maxK, int[] prices) {
        if (prices.length == 0 || maxK == 0) {
            return 0;
        }

        int[][][] dp = new int[prices.length][maxK + 1][2];
        //初始话base case
        for (int i = 0; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < prices.length; i++) {
            for (int k = 1; k <= maxK; k++) {
                if (i == 0) {
                    //dp[0][k][0] = max(dp[-1][k][0], dp[-1][k][1] + prices[0])
                    dp[0][k][0] = 0;
                    //dp[0][k][1] = max(dp[-1][k][1], dp[-1][k-1][0] - prices[0])
                    dp[0][k][1] = -prices[0];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][maxK][0];
    }

    public static void main(String[] args) {
        //2
        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(2, new int[]{2, 4, 1}));
        //7
        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
        //469
//        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(7, new int[]{48, 12, 60, 93, 97, 42, 25, 64, 17, 56, 85, 93, 9, 48, 52, 42, 58, 85, 81, 84, 69, 36, 1, 54, 23, 15, 72, 15, 11, 94}));

        //2
        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit2(2, new int[]{2, 4, 1}));
        //7
        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit2(2, new int[]{3, 2, 6, 5, 0, 3}));
        //469
        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit2(7, new int[]{48, 12, 60, 93, 97, 42, 25, 64, 17, 56, 85, 93, 9, 48, 52, 42, 58, 85, 81, 84, 69, 36, 1, 54, 23, 15, 72, 15, 11, 94}));
    }
}
