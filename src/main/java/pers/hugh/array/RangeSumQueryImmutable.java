package pers.hugh.array;

/**
 * @author dingxiuzheng
 */
public class RangeSumQueryImmutable {

    static class NumArray {

        //303. Range Sum Query - Immutable
        //https://leetcode.com/problems/range-sum-query-immutable/
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }


    static class NumArray2 {

        //303. Range Sum Query - Immutable
        //https://leetcode.com/problems/range-sum-query-immutable/
        private int[] preNum;

        public NumArray2(int[] nums) {
            preNum = new int[nums.length + 1];
            preNum[0] = nums[0];
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                preNum[i + 1] = preNum[i] + num;
            }
        }

        public int sumRange(int left, int right) {
            return preNum[right + 1] - preNum[left];
        }
    }


    public static void main(String[] args) {
        System.out.println(new NumArray(new int[]{-2, 0, 3, -5, 2, -1}).sumRange(0, 2));
        System.out.println(new NumArray(new int[]{-2, 0, 3, -5, 2, -1}).sumRange(2, 5));
        System.out.println(new NumArray(new int[]{-2, 0, 3, -5, 2, -1}).sumRange(0, 5));
        System.out.println(new NumArray2(new int[]{-2, 0, 3, -5, 2, -1}).sumRange(0, 2));
        System.out.println(new NumArray2(new int[]{-2, 0, 3, -5, 2, -1}).sumRange(2, 5));
        System.out.println(new NumArray2(new int[]{-2, 0, 3, -5, 2, -1}).sumRange(0, 5));
    }
}
