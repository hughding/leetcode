package pers.hugh.array;

import java.util.*;

/**
 * @author dingxiuzheng
 */
public class ThreeSum {

    //15. 3Sum
    //https://leetcode.com/problems/3sum/

    private List<List<Integer>> result;
    private LinkedList<Integer> track;
    private int sum;

    public List<List<Integer>> threeSum(int[] nums) {
        result = new ArrayList<>();
        track = new LinkedList<>();
        sum = 0;
        Arrays.sort(nums);
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int start) {
        if (track.size() == 3) {
            if (sum == 0) {
                result.add(new ArrayList<>(track));
            }
            return;
        }
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            sum += nums[i];
            backtrack(nums, i + 1);
            sum -= nums[i];
            track.removeLast();
        }
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> tupleList = twoSum(nums, i + 1, -nums[i]);
            for (List<Integer> tuple : tupleList) {
                tuple.add(0, nums[i]);
                res.add(tuple);
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int i = start, j = nums.length - 1;
        while (j > i) {
            int left = nums[i];
            int right = nums[j];
            int sum = left + right;
            if (sum > target) {
                while (i < j && nums[j] == right) {
                    j--;
                }
            } else if (sum < target) {
                while (i < j && nums[i] == left) {
                    i++;
                }
            } else {
                List<Integer> tuple = new ArrayList<>(Arrays.asList(left, right));
                res.add(tuple);
                while (i < j && nums[i] == left) {
                    i++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new ThreeSum().threeSum(new int[]{0, 1, 1}));
        System.out.println(new ThreeSum().threeSum(new int[]{0, 0, 0}));
        System.out.println(new ThreeSum().threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new ThreeSum().threeSum2(new int[]{0, 1, 1}));
        System.out.println(new ThreeSum().threeSum2(new int[]{0, 0, 0}));
    }

}
