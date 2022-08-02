package pers.hugh.binarytree;

import java.util.Arrays;

/**
 * @author dingxiuzheng
 */
public class SortAnArray {

    //912. Sort an Array
    //https://leetcode.com/problems/sort-an-array/
    //虽是数组问题，但是归并排序用的二叉树的思想，二叉树后序遍历。

    private int[] tmp;

    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid + 1, high);
        merge(nums, low, high, mid);
    }

    private void merge(int[] nums, int low, int high, int mid) {
        int i = low;
        int j = mid + 1;
        for (int p = low; p <= high; p++) {
            if (i > mid) {
                tmp[p] = nums[j++];
            } else if (j > high) {
                tmp[p] = nums[i++];
            } else if (nums[i] <= nums[j]) {
                tmp[p] = nums[i++];
            } else if (nums[i] > nums[j]) {
                tmp[p] = nums[j++];
            }
        }
        for (int p = low; p <= high; p++) {
            nums[p] = tmp[p];
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortAnArray().sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(new SortAnArray().sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
