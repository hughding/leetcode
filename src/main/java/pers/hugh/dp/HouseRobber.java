package pers.hugh.dp;

import java.util.Arrays;

/**
 * @author dingxiuzheng
 */
public class HouseRobber {

    //198. House Robber
    //https://leetcode.com/problems/house-robber/

    //dp[i] = max(dp[i-1], dp[i-2] + nums[i])

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public int rob2(int[] nums) {
        return dp(nums, 0);
    }

    private int dp(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        return Math.max(nums[i] + dp(nums, i + 2), dp(nums, i + 1));
    }

    private int[] memo;

    public int rob3(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp3(nums, 0);
    }

    private int dp3(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int res = Math.max(nums[i] + dp3(nums, i + 2), dp3(nums, i + 1));
        memo[i] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new HouseRobber().rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(new HouseRobber().rob2(new int[]{1, 2, 3, 1}));
        System.out.println(new HouseRobber().rob2(new int[]{2, 7, 9, 3, 1}));
        System.out.println(new HouseRobber().rob3(new int[]{1, 2, 3, 1}));
        System.out.println(new HouseRobber().rob3(new int[]{2, 7, 9, 3, 1}));
    }
}
