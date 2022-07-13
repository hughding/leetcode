package pers.hugh.binarysearch;

/**
 * @author dingxiuzheng
 */
public class BinarySearch {

    //704. Binary Search
    //https://leetcode.com/problems/binary-search/

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

}
