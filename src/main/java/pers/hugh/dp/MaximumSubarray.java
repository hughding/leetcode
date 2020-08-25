package pers.hugh.dp;

/**
 * @author hughding
 * @date 2020/8/25 19:45
 **/
public class MaximumSubarray {
//    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//    Example:
//
//    Input: [-2,1,-3,4,-1,2,1,-5,4],
//    Output: 6
//    Explanation: [4,-1,2,1] has the largest sum = 6.
//    Follow up:
//
//    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

    //dp[i] = max(ap[i-1], 0) + num[i]
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                dp[0] = nums[0];
                continue;
            }

            dp[i] = Math.max(dp[i-1], 0) + nums[i];
        }

        int max = dp[0];
        for (int sum : dp) {
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution.maxSubArray(new int[]{-1}));
    }

}
