package pers.hugh.binarytree;

/**
 * @author dingxiuzheng
 */
public class ReversePairs {
    //493. Reverse Pairs
    //https://leetcode.com/problems/reverse-pairs/

    private int[] tmp;
    private int count;

    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        count = 0;
        sort(nums, 0, nums.length - 1);
        return count;
    }

    private void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, high, mid);
    }

    private void merge(int[] arr, int low, int high, int mid) {
        int end = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (end <= high && arr[i] / 2.0 > arr[end]) {
                end++;
            }
            count += end - (mid + 1);
        }

        int i = low;
        int j = mid + 1;
        int p = low;
        //在while里for循环，TLE
        while (p <= high) {
            if (i > mid) {
                tmp[p++] = arr[j++];
            } else if (j > high) {
                tmp[p++] = arr[i++];
            } else if (arr[i] <= arr[j]) {
                tmp[p++] = arr[i++];
            } else if (arr[i] > arr[j]) {
                tmp[p++] = arr[j++];
            }
        }
        for (p = low; p <= high; p++) {
            arr[p] = tmp[p];
        }
    }

    public int reversePairs2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] / 2.0 > nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(new int[]{1, 3, 2, 3, 1}));
        System.out.println(reversePairs.reversePairs(new int[]{2, 4, 3, 5, 1}));
        System.out.println(reversePairs.reversePairs(new int[]{-5, -5}));

        System.out.println(reversePairs.reversePairs2(new int[]{1, 3, 2, 3, 1}));
        System.out.println(reversePairs.reversePairs2(new int[]{2, 4, 3, 5, 1}));
        System.out.println(reversePairs.reversePairs2(new int[]{-5, -5}));
    }
}
