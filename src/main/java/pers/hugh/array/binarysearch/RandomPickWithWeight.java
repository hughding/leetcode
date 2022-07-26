package pers.hugh.array.binarysearch;

import java.util.Random;

/**
 * @author dingxiuzheng
 */
public class RandomPickWithWeight {

    //528. Random Pick with Weight
    //https://leetcode.com/problems/random-pick-with-weight/

    static class Solution {

        private static Random random = new Random();

        private int[] preSum;

        public Solution(int[] w) {
            preSum = new int[w.length];
            preSum[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                preSum[i] = preSum[i - 1] + w[i];
            }
        }

        //准确来说，应返回二分搜索的左边界

        public int pickIndex() {
            int randomInt = random.nextInt(preSum[preSum.length - 1]) + 1;
            int i = 0, j = preSum.length - 1;
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (randomInt == preSum[mid]) {
                    j = mid - 1;
                } else if (randomInt < preSum[mid]) {
                    j = mid - 1;
                } else if (randomInt > preSum[mid]) {
                    i = mid + 1;
                }
            }
            return i;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1});
        for (int i = 0; i < 5; i++) {
            System.out.println(solution.pickIndex());
        }

        System.out.println("================");
        Solution solution2 = new Solution(new int[]{1, 3});
        for (int i = 0; i < 5; i++) {
            System.out.println(solution2.pickIndex());
        }
    }
}
