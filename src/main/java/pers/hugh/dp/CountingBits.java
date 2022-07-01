package pers.hugh.dp;

import java.util.Arrays;

/**
 * @author dingxiuzheng
 */
public class CountingBits {

//    338. Counting Bits
//
//    Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
//
//    Example 1:
//
//    Input: n = 2
//    Output: [0,1,1]
//    Explanation:
//            0 --> 0
//            1 --> 1
//            2 --> 10
//    Example 2:
//
//    Input: n = 5
//    Output: [0,1,1,2,1,2]
//    Explanation:
//            0 --> 0
//            1 --> 1
//            2 --> 10
//            3 --> 11
//            4 --> 100
//            5 --> 101
//
//
//    Constraints:
//
//            0 <= n <= 105
//
//
//    Follow up:
//
//    It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
//    Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int item = 0;
            for (int j = 0; j <= 17; j++) {
                if (((i >> j) & 1) == 1) {
                    item++;
                }
            }
            result[i] = item;
        }
        return result;
    }

    public int[] countBits2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if(i%2 == 0){
                dp[i] = dp[i/2];
            }else{
                dp[i] = dp[i-1] + 1;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits().countBits(2)));
        System.out.println(Arrays.toString(new CountingBits().countBits(5)));
        System.out.println(Arrays.toString(new CountingBits().countBits2(2)));
        System.out.println(Arrays.toString(new CountingBits().countBits2(5)));
    }
}
