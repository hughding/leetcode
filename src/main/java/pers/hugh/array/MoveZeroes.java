package pers.hugh.array;

import java.util.Arrays;

/**
 * @author dingxiuzheng
 */
public class MoveZeroes {

    //283. Move Zeroes
    //https://leetcode.com/problems/move-zeroes/

    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(a1);
        System.out.println(Arrays.toString(a1));
        int[] a2 = new int[]{0};
        new MoveZeroes().moveZeroes(a2);
        System.out.println(Arrays.toString(a2));
        int[] a3 = new int[]{1, 0, 0, 3, 12};
        new MoveZeroes().moveZeroes(a3);
        System.out.println(Arrays.toString(a3));
        int[] a4 = new int[]{1, 2, 3, 4, 5};
        new MoveZeroes().moveZeroes(a4);
        System.out.println(Arrays.toString(a4));
    }
}
