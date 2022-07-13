package pers.hugh.binarysearch;

import java.util.Arrays;

/**
 * @author dingxiuzheng
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    //34. Find First and Last Position of Element in Sorted Array
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    public int[] searchRange(int[] nums, int target) {
        int leftBound = leftBound(nums, target);
        int rightBound = rightBound(nums, target);
        return new int[]{leftBound, rightBound};
    }

    public int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    public int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if(right < 0){
            return -1;
        }
        return nums[right] == target ? right : -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(
                new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(
                new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(
                new int[]{}, 0)));
    }
}
