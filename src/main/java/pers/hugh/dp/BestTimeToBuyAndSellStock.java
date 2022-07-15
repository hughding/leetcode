package pers.hugh.dp;

/**
 * 也可以贪心算法解决
 * @see pers.hugh.greedy.BestTimeToBuyAndSellStock
 *
 * @author dingxiuzheng
 */
public class BestTimeToBuyAndSellStock {

    //121. Best Time to Buy and Sell Stock
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    //套用通用公式
    //dp
    //dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
    //dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
    //            = max(dp[i-1][1][1], 0 - prices[i])
    //省略k
    //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    //dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
    //            = max(dp[i-1][1], 0 - prices[i])
    //
    //dp[0][0] = max(dp[-1][0], dp[-1][1] + prices[i])
    //dp[0][1] = max(dp[-1][1], 0 - prices[i])

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(new int[]{1, 2}));
    }
}
