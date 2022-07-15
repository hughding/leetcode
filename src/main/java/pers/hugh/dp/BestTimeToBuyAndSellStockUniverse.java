package pers.hugh.dp;

/**
 * @author dingxiuzheng
 */
public class BestTimeToBuyAndSellStockUniverse {

    //股票问题，万法归一
    //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
    //dp[i][k][1] = max(dp[i-1][k][1], dp[i-cooldown][k-1][0] - prices[i] - fee)
    //
    //base case
    //dp[-1][...][0] = 0
    //dp[-1][...][1] = 负无穷
    //dp[-cooldown:-1][...][0] = 0
    //dp[-cooldown:-1][...][1] = 负无穷
    //dp[...][0][0] = 0
    //dp[...][0][1] = 负无穷

    public int maxProfit(int[] prices, int maxK, int cooldown, int fee) {
        if (prices.length == 0 || maxK == 0) {
            return 0;
        }
        int[][][] dp = new int[prices.length][maxK + 1][2];
        for (int i = 0; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < prices.length; i++) {
            for (int k = 1; k <= maxK; k++) {
                if (i - 1 == -1) {
                    //dp[0][k][0] = max(dp[-1][k][0], dp[-1][k][1] + prices[0])
                    dp[0][k][0] = 0;
                    //dp[0][k][1] = max(dp[-1][k][1], dp[-cooldown][k-1][0] - prices[0] - fee)
                    dp[0][k][1] = -prices[0] - fee;
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                if (i - cooldown >= 0) {
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - cooldown][k - 1][0] - prices[i] - fee);
                } else {
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], -prices[i] - fee);
                }
            }
        }

        return dp[prices.length - 1][maxK][0];
    }

    public static void main(String[] args) {
        //假设maxK正无穷为100,避免测试时较大的计算
        int MAX_K = 100;

        //121. Best Time to Buy and Sell Stock
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
        //result = 5
        System.out.println(new BestTimeToBuyAndSellStockUniverse().maxProfit(
                new int[]{7, 1, 5, 3, 6, 4}, 1, 1, 0));
        //result = 0
        System.out.println(new BestTimeToBuyAndSellStockUniverse().maxProfit(
                new int[]{7, 6, 4, 3, 1}, 1, 1, 0));

        //122. Best Time to Buy and Sell Stock II
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
        //result = 7
        System.out.println(new BestTimeToBuyAndSellStockUniverse().maxProfit(
                new int[]{7, 1, 5, 3, 6, 4}, MAX_K, 1, 0));
        //result = 4
        System.out.println(new BestTimeToBuyAndSellStockUniverse().maxProfit(
                new int[]{1, 2, 3, 4, 5}, MAX_K, 1, 0));

        //123. Best Time to Buy and Sell Stock III
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
        //result = 6
        System.out.println(new BestTimeToBuyAndSellStockUniverse().maxProfit(
                new int[]{3, 3, 5, 0, 0, 3, 1, 4}, 2, 1, 0));
        //result = 4
        System.out.println(new BestTimeToBuyAndSellStockUniverse().maxProfit(
                new int[]{1, 2, 3, 4, 5}, 2, 1, 0));
        //result = 0
        System.out.println(new BestTimeToBuyAndSellStockUniverse().maxProfit(
                new int[]{7, 6, 4, 3, 1}, 2, 1, 0));

        //188. Best Time to Buy and Sell Stock IV
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
        //result = 2
        System.out.println(new BestTimeToBuyAndSellStockUniverse().maxProfit(
                new int[]{2, 4, 1}, 2, 1, 0));
        //result = 7
        System.out.println(new BestTimeToBuyAndSellStockUniverse().maxProfit(
                new int[]{3, 2, 6, 5, 0, 3}, 2, 1, 0));

        //309. Best Time to Buy and Sell Stock with Cooldown
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
        //result = 3
        System.out.println(new BestTimeToBuyAndSellStockUniverse().maxProfit(
                new int[]{1, 2, 3, 0, 2}, MAX_K, 2, 0));
        //result = 0
        System.out.println(new BestTimeToBuyAndSellStockUniverse().maxProfit(
                new int[]{1}, MAX_K, 2, 0));

        //714. Best Time to Buy and Sell Stock with Transaction Fee
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
        //result = 8
        System.out.println(new BestTimeToBuyAndSellStockUniverse().maxProfit(
                new int[]{1, 3, 2, 8, 4, 9}, MAX_K, 1, 2));
        //result = 6
        System.out.println(new BestTimeToBuyAndSellStockUniverse().maxProfit(
                new int[]{1, 3, 7, 5, 10, 3}, MAX_K, 1, 3));
    }
}
