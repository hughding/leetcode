package pers.hugh.array;

import java.util.Arrays;

/**
 * @author dingxiuzheng
 */
public class RemoveElement {

    //27. Remove Element
    //https://leetcode.com/problems/remove-element/

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{3, 2, 2, 3};
        System.out.println(new RemoveElement().removeElement(a1, 3));
        System.out.println(Arrays.toString(a1));
        int[] a2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new RemoveElement().removeElement(a2, 2));
        System.out.println(Arrays.toString(a2));
    }
}
