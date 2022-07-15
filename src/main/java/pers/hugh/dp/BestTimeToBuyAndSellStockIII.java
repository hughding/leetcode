package pers.hugh.dp;

/**
 * @author dingxiuzheng
 */
public class BestTimeToBuyAndSellStockIII {

//    123. Best Time to Buy and Sell Stock III
//    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
//
//    You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//    Find the maximum profit you can achieve. You may complete at most two transactions.
//
//            Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
//
//
//
//    Example 1:
//
//    Input: prices = [3,3,5,0,0,3,1,4]
//    Output: 6
//    Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
//    Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
//    Example 2:
//
//    Input: prices = [1,2,3,4,5]
//    Output: 4
//    Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//    Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
//    Example 3:
//
//    Input: prices = [7,6,4,3,1]
//    Output: 0
//    Explanation: In this case, no transaction is done, i.e. max profit = 0.
//
//
//    Constraints:
//
//            1 <= prices.length <= 105
//            0 <= prices[i] <= 105


    //dp[i][k][0] = Max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
    //dp[i][k][1] = Max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
    //
    //dp[0][...][0] = 0
    //dp[0][0][1] = 此种情况不存在，所以设置负无穷
    //dp[0][1:k][1] = -prices[0]
    //
    //dp[...][0][0] = 0
    //dp[...][0][1] = 此种情况不存在，所以设置负无穷

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][3][2];
        for (int i = 0; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int k = 0; k < 3; k++) {
            dp[0][k][0] = 0;
            if (k == 0) {
                dp[0][0][1] = Integer.MIN_VALUE;
            } else {
                dp[0][k][1] = -prices[0];
            }

        }

        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k <= 2; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][2][0];
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
