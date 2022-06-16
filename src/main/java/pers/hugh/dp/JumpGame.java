package pers.hugh.dp;

/**
 * @author dingxiuzheng
 */
public class JumpGame {


//    55. Jump Game
//    You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
//
//    Return true if you can reach the last index, or false otherwise.
//
//
//
//            Example 1:
//
//    Input: nums = [2,3,1,1,4]
//    Output: true
//    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//            Example 2:
//
//    Input: nums = [3,2,1,0,4]
//    Output: false
//    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
//
//
//            Constraints:
//
//            1 <= nums.length <= 104
//            0 <= nums[i] <= 105

    //dp[i+j] = dp[i]; 1 <= j <= nums[j]

    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for (int i = 0; i < dp.length; i++) {
            int maxStep = nums[i];
            for (int j = 1; j <= maxStep; j++) {
                if (i + j >= nums.length) {
                    break;
                }
                dp[i + j] = dp[i];
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
