package pers.hugh.dp;

/**
 * @author dingxiuzheng
 */
public class HouseRobberII {

    //213. House Robber II
    //https://leetcode.com/problems/house-robber-ii/

    public int rob(int[] nums) {
        int res1 = dp(nums, 0, nums.length - 2);
        int res2 = dp(nums, 1, nums.length - 1);
        return Math.max(res1, res2);
    }

    public int dp(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(new int[]{2, 3, 2}));
        System.out.println(new HouseRobberII().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new HouseRobberII().rob(new int[]{1, 2, 3}));
    }
}
