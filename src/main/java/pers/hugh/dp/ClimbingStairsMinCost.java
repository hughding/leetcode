package pers.hugh.dp;

/**
 * @author dingxiuzheng
 */
public class ClimbingStairsMinCost {
//    746. Min Cost Climbing Stairs
//
//    You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
//
//    You can either start from the step with index 0, or the step with index 1.
//
//    Return the minimum cost to reach the top of the floor.
//
//
//
//            Example 1:
//
//    Input: cost = [10,15,20]
//    Output: 15
//    Explanation: You will start at index 1.
//            - Pay 15 and climb two steps to reach the top.
//    The total cost is 15.
//    Example 2:
//
//    Input: cost = [1,100,1,1,1,100,1,1,100,1]
//    Output: 6
//    Explanation: You will start at index 0.
//            - Pay 1 and climb two steps to reach index 2.
//            - Pay 1 and climb two steps to reach index 4.
//            - Pay 1 and climb two steps to reach index 6.
//            - Pay 1 and climb one step to reach index 7.
//            - Pay 1 and climb two steps to reach index 9.
//            - Pay 1 and climb one step to reach the top.
//    The total cost is 6.
//
//
//    Constraints:
//
//            2 <= cost.length <= 1000
//            0 <= cost[i] <= 999

    //dp[n] = Min(dp[n-1] + cost[n-1],dp[n-2] + cost[n-2])
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return Math.min(dp[cost.length - 1] + cost[cost.length - 1], dp[cost.length - 2] + cost[cost.length - 2]);
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairsMinCost().minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(new ClimbingStairsMinCost().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
