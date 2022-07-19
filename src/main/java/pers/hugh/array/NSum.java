package pers.hugh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class NSum {

    public List<List<Integer>> nSum(int[] nums, int n, int start, long target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2) {
            return res;
        }
        if (n == 2) {
            return towSum(nums, start, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> tuples = nSum(nums, n - 1, i + 1, target - (long) nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(0, nums[i]);
                res.add(tuple);
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
        System.out.println(new NSum().nSum(new int[]{1, 0, -1, 0, -2, 2}, 4, 0, 0));
        System.out.println(new NSum().nSum(new int[]{2, 2, 2, 2, 2}, 4, 0, 8));
        System.out.println(new NSum().nSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, 4, 0, -294967296));
    }
}
