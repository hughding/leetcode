package pers.hugh.binarytree;

import java.util.Arrays;

/**
 * @author dingxiuzheng
 */
public class SortAnArray {

    //912. Sort an Array
    //https://leetcode.com/problems/sort-an-array/
    //虽是数组问题，但是归并排序用的二叉树的思想，二叉树后序遍历。

    static class MergeSort {
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
    }

    static class QuickSort {
        public int[] sortArray(int[] nums) {
            sort(nums, 0, nums.length - 1);
            return nums;
        }

        private void sort(int[] nums, int low, int high) {
            if (low >= high) {
                return;
            }
            int p = partition(nums, low, high);
            sort(nums, low, p - 1);
            sort(nums, p + 1, high);
        }

        private int partition(int[] nums, int low, int high) {
            int pivot = nums[low];
            int i = low + 1;
            int j = high;
            while (i <= j) {
                while (i < high && nums[i] <= pivot) {
                    i++;
                }
                while (j > low && nums[j] > pivot) {
                    j--;
                }
                if(i >= j){
                    break;
                }
                swap(nums, i, j);
            }
            swap(nums, low, j);
            return j;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        SortAnArray.MergeSort mergeSort = new SortAnArray.MergeSort();
        System.out.println(Arrays.toString(mergeSort.sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(mergeSort.sortArray(new int[]{5, 1, 1, 2, 0, 0})));
        SortAnArray.QuickSort quickSort = new SortAnArray.QuickSort();
        System.out.println(Arrays.toString(quickSort.sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(quickSort.sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
