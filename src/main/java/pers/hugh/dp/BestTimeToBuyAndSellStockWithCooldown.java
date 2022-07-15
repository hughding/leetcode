package pers.hugh.dp;

/**
 * @author dingxiuzheng
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    //309. Best Time to Buy and Sell Stock with Cooldown
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

    //dp[i][0] = Max(dp[i-1][0], dp[i-1][1] + prices[i])
    //dp[i][1] = Max(dp[i-1][1], dp[i-2][0] - prices[i])
    //
    //dp[0][0] = 0
    //dp[0][1] = -prices[0]
    //dp[1][0] = Max(dp[0][0], dp[0][1] + prices[1]) = Max(0, -prices[0] + prices[1]);
    //dp[1][1] = Max(dp[0][1], dp[-1][0] - prices[1]) = Max(-prices[0], -prices[1]);

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }
            if (i == 1) {
                dp[1][0] = Math.max(0, prices[1] - prices[0]);
                dp[1][1] = Math.max(-prices[0], -prices[1]);
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(new int[]{1}));
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(new int[]{1, 2, 4}));
    }
}
