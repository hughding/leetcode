package pers.hugh.binarytree;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author dingxiuzheng
 */
public class KthLargestElementInAnArray {

    //215. Kth Largest Element in an Array
    //https://leetcode.com/problems/kth-largest-element-in-an-array/

    //扫描总次数=N + N/2 + N/4 + ... + 1 = 2N (等比数列求和)
    //所以此算法时间复杂度O(N)

    public int findKthLargest(int[] nums, int k) {
        return sort(nums, 0, nums.length - 1, nums.length - k);
    }

    private int sort(int[] nums, int low, int high, int k) {
        if (low >= high) {
            return low == k ? nums[low] : -1;
        }
        int p = partition(nums, low, high);
        if (k == p) {
            return nums[p];
        }
        if (k > p) {
            return sort(nums, p + 1, high, k);
        } else {
            return sort(nums, low, p - 1, k);
        }
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
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, j, low);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //K个元素的小根堆，添加、删除时间复杂度O(logK)，所以此算法时间复杂度O(NlogK)
    public int findKthLargest2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(solution.findKthLargest(new int[]{1}, 1));
        System.out.println(solution.findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution.findKthLargest2(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(solution.findKthLargest2(new int[]{1}, 1));
    }
}
