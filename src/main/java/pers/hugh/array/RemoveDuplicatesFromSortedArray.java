package pers.hugh.array;

import java.util.Arrays;

/**
 * @author dingxiuzheng
 */
public class RemoveDuplicatesFromSortedArray {

    //26. Remove Duplicates from Sorted Array
    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i = 1;
        while (i < len) {
            if (nums[i] == nums[i - 1]) {
                for (int j = i; j < len; j++) {
                    nums[j - 1] = nums[j];
                }
                len--;
            } else {
                i++;
            }
        }
        return len;
    }

    public int removeDuplicates2(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            if(nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 1, 2};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(a1));
        System.out.println(Arrays.toString(a1));
        int[] a2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(a2));
        System.out.println(Arrays.toString(a2));

        a1 = new int[]{1, 1, 2};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates2(a1));
        System.out.println(Arrays.toString(a1));
        a2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates2(a2));
        System.out.println(Arrays.toString(a2));
    }
}
