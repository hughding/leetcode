package pers.hugh.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author dingxiuzheng
 */
public class AdvantageShuffle {

    //870. Advantage Shuffle
    //https://leetcode.com/problems/advantage-shuffle/

    //O(N^2)
    public int[] advantageCount(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums2.length; i++) {
            int n2 = nums2[i];
            int min = i, advantage = i;
            for (int j = i + 1; j < nums1.length; j++) {
                if (nums1[min] > nums1[j]) {
                    min = j;
                }
                if (nums1[j] > n2) {
                    if (nums1[advantage] <= n2) {
                        advantage = j;
                    } else {
                        advantage = min(nums1, advantage, j);
                    }
                }
            }
            if (nums1[advantage] > n2) {
                swap(nums1, i, advantage);
            } else {
                swap(nums1, i, min);
            }
        }
        return nums1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int min(int[] nums, int i, int j) {
        if (nums[i] < nums[j]) {
            return i;
        } else {
            return j;
        }
    }

    //O(NlogN)
    public int[] advantageCount2(int[] nums1, int[] nums2) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < nums2.length; i++) {
            queue.add(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);
        int left = 0;
        int right = nums1.length - 1;
        int[] res = new int[nums1.length];

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0], maxVal = node[1];
            if (nums1[right] > maxVal) {
                res[i] = nums1[right];
                right--;
            } else {
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AdvantageShuffle().advantageCount(
                new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
        System.out.println(Arrays.toString(new AdvantageShuffle().advantageCount(
                new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
        System.out.println(Arrays.toString(new AdvantageShuffle().advantageCount2(
                new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
        System.out.println(Arrays.toString(new AdvantageShuffle().advantageCount2(
                new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
    }
}
