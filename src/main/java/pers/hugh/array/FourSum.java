package pers.hugh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class FourSum {

    //18. 4Sum
    //https://leetcode.com/problems/4sum/

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                long subTarget = (long) target - (long) nums[i] - (long) nums[j];
                List<List<Integer>> tuples = towSum(nums, j + 1, subTarget);
                for (List<Integer> tuple : tuples) {
                    tuple.add(0, nums[j]);
                    tuple.add(0, nums[i]);
                    res.add(tuple);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> towSum(int[] nums, int start, long target) {
        List<List<Integer>> res = new ArrayList<>();
        int i = start, j = nums.length - 1;
        while (i < j) {
            int left = nums[i];
            int right = nums[j];
            long sum = (long) left + (long) right;
            if (sum < target) {
                while (i < j && nums[i] == left) {
                    i++;
                }
            } else if (sum > target) {
                while (i < j && nums[j] == right) {
                    j--;
                }
            } else {
                res.add(new ArrayList<>(Arrays.asList(left, right)));
                while (i < j && nums[i] == left) {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(new FourSum().fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        System.out.println(new FourSum().fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }
}
