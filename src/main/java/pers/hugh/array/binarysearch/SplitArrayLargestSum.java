package pers.hugh.array.binarysearch;

/**
 * @author dingxiuzheng
 */
public class SplitArrayLargestSum {

    //410. Split Array Largest Sum
    //https://leetcode.com/problems/split-array-largest-sum/

    public int splitArray(int[] nums, int m) {
        int left = nums[0], right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        //f(x)标识最大和为x的情况下，划分成m个。
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midF = f(nums, mid);
            if (m == midF) {
                right = mid - 1;
            } else if (m > midF) {
                right = mid - 1;
            } else if (m < midF) {
                left = mid + 1;
            }
        }
        return left;
    }

    public int f(int[] nums, int sum) {
        int m = 1;
        int tmpSum = 0;
        for (int num : nums) {
            if (tmpSum + num > sum) {
                tmpSum = num;
                m++;
            } else {
                tmpSum += num;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(new SplitArrayLargestSum().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(new SplitArrayLargestSum().splitArray(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println(new SplitArrayLargestSum().splitArray(new int[]{1, 4, 4}, 3));
    }
}
