package pers.hugh.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class CountOfSmallerNumbersAfterSelf {

    //315. Count of Smaller Numbers After Self
    //https://leetcode.com/problems/count-of-smaller-numbers-after-self/

    //TLE
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int r = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    r++;
                }
            }
            res.add(r);
        }
        return res;
    }


    private Pair[] tmp;

    private int[] count;

    static class Pair {
        int index;
        int val;

        Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public List<Integer> countSmaller2(int[] nums) {
        tmp = new Pair[nums.length];
        count = new int[nums.length];
        Pair[] arr = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(i, nums[i]);
        }
        List<Integer> res = new ArrayList<>();
        sort(arr, 0, nums.length - 1);
        for (int c : count) {
            res.add(c);
        }
        return res;
    }

    private void sort(Pair[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge2(arr, low, high, mid);
    }


    private void merge(Pair[] arr, int low, int high, int mid) {
        int i = low;
        int j = mid + 1;
        int p = low;
        while (p <= high) {
            if (i > mid) {
                tmp[p++] = arr[j++];
            } else if (j > high) {
                tmp[p++] = arr[i++];
                count[arr[i - 1].index] += j - mid - 1;
            } else if (arr[i].val <= arr[j].val) {
                tmp[p++] = arr[i++];
                count[arr[i - 1].index] += j - mid - 1;
            } else if (arr[i].val > arr[j].val) {
                tmp[p++] = arr[j++];
            }
        }
        for (p = low; p <= high; p++) {
            arr[p] = tmp[p];
        }
    }

    private void merge2(Pair[] arr, int low, int high, int mid) {
        int end = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (end <= high && arr[i].val > arr[end].val) {
                end++;
            }
            count[arr[i].index] += end - (mid + 1);
        }

        int i = low;
        int j = mid + 1;
        int p = low;
        while (p <= high) {
            if (i > mid) {
                tmp[p++] = arr[j++];
            } else if (j > high) {
                tmp[p++] = arr[i++];
            } else if (arr[i].val <= arr[j].val) {
                tmp[p++] = arr[i++];
            } else if (arr[i].val > arr[j].val) {
                tmp[p++] = arr[j++];
            }
        }
        for (p = low; p <= high; p++) {
            arr[p] = tmp[p];
        }
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf solution = new CountOfSmallerNumbersAfterSelf();
        System.out.println(solution.countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(solution.countSmaller(new int[]{-1}));
        System.out.println(solution.countSmaller(new int[]{-1, -1}));
        System.out.println(solution.countSmaller2(new int[]{5, 2, 6, 1}));
        System.out.println(solution.countSmaller2(new int[]{-1}));
        System.out.println(solution.countSmaller2(new int[]{-1, -1}));
    }
}
