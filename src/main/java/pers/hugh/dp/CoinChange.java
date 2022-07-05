package pers.hugh.dp;

/**
 * @author dingxiuzheng
 */
public class CoinChange {

    //322. Coin Change
    //https://leetcode.com/problems/coin-change/

    //方法1：暴力破解
    public int coinChange(int[] coins, int amount) {
        //硬币金额和总额不匹配
        if (amount < 0) {
            return -1;
        }
        //硬币金额==总额
        if (amount == 0) {
            return 0;
        }
        int minCoinCount = amount + 1;
        for (int coin : coins) {
            int coinCount = coinChange(coins, amount - coin);
            if (coinCount == -1) {
                continue;
            }
            minCoinCount = Math.min(minCoinCount, coinCount + 1);
        }
        if (minCoinCount == amount + 1) {
            return -1;
        } else {
            return minCoinCount;
        }
    }

    //方法2：自顶向下
    private int[] mem;

    public int coinChange2(int[] coins, int amount) {
        mem = new int[amount + 1];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = -2;
        }
        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount) {
        //硬币金额和总额不匹配
        if (amount < 0) {
            return -1;
        }
        //硬币金额==总额
        if (amount == 0) {
            return 0;
        }
        if (mem[amount] != -2) {
            return mem[amount];
        }
        int minCoinCount = amount + 1;
        for (int coin : coins) {
            int coinCount = dp(coins, amount - coin);
            if (coinCount == -1) {
                continue;
            }
            minCoinCount = Math.min(minCoinCount, coinCount + 1);
        }
        if (minCoinCount == amount + 1) {
            mem[amount] = -1;
            return -1;
        } else {
            mem[amount] = minCoinCount;
            return minCoinCount;
        }
    }

    //方法3：自底向上
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int coin : coins) {
            if(coin < amount){
                dp[coin] = 1;
            }
        }
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        } else {
            return dp[amount];
        }
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange().coinChange2(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange().coinChange3(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange().coinChange3(new int[]{1}, 0));
        System.out.println(new CoinChange().coinChange3(new int[]{2}, 1));
        System.out.println(new CoinChange().coinChange3(new int[]{1}, 1));
    }
}
