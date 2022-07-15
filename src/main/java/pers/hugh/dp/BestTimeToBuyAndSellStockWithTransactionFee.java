package pers.hugh.dp;

/**
 * @author dingxiuzheng
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    //714. Best Time to Buy and Sell Stock with Transaction Fee
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

    //dp[i][0] = Max(dp[i-1][0], dp[i-1][1] + prices[i] - fee)
    //dp[i][1] = Max(dp[i-1][1], dp[i-1][0] - prices[i])
    //dp[0][0] = 0;
    //dp[0][1] = -prices[0];

    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }
}
