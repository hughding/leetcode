package pers.hugh.leetcode;

/**
 * @author hughding
 * @date 2020/9/18 15:28
 **/
public class TwoSumII {
//    167. Two Sum II - Input array is sorted
//
//    Add to List
//
//            Share
//    Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//
//    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
//
//            Note:
//
//    Your returned answers (both index1 and index2) are not zero-based.
//    You may assume that each input would have exactly one solution and you may not use the same element twice.

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                break;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        int[] result = new int[]{i + 1, j + 1};
        return result;
    }

    public static void main(String[] args) {
        TwoSumII solution = new TwoSumII();
        print(solution.twoSum(new int[]{2, 7, 11, 15}, 9));
        print(solution.twoSum(new int[]{2, 3, 4}, 6));
        print(solution.twoSum(new int[]{-1, 0}, -1));
    }

    private static void print(int[] result) {
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
