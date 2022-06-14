package pers.hugh.dp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class JumpGameII {

//    45. Jump Game II
//    Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
//
//    Each element in the array represents your maximum jump length at that position.
//
//    Your goal is to reach the last index in the minimum number of jumps.
//
//    You can assume that you can always reach the last index.
//
//    Example 1:
//
//    Input: nums = [2,3,1,1,4]
//    Output: 2
//    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
//            Example 2:
//
//    Input: nums = [2,3,0,1,4]
//    Output: 2
//
//
//    Constraints:
//
//            1 <= nums.length <= 104
//            0 <= nums[i] <= 1000

    public int jump(int[] nums) {
        List<Integer> result = new ArrayList<>();
        jumpResult(nums, 0, 0, result);
        result.sort(Comparator.comparingInt(n -> n));
        return result.get(0);
    }

    private void jumpResult(int[] nums, int pos, int step, List<Integer> result) {
        if (pos == nums.length - 1) {
            result.add(step);
        } else if (pos < nums.length - 1) {
            if (nums[pos] == 0) {
                return;
            }
            for (int i = 1; i <= nums[pos]; i++) {
                jumpResult(nums, pos + i, step + 1, result);
            }
        }
    }

    //dp[i] = Min(dp[i-j] + 1)   1 <= j <= nums[i-j]

    public int jumpDp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 1; j <= i; j++) {
                if (j <= nums[i - j]) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new JumpGameII().jumpDp(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGameII().jumpDp(new int[]{2, 3, 0, 1, 4}));
    }
}
