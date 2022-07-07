package pers.hugh.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class Subsets {

    //78. Subsets
    //https://leetcode.com/problems/subsets/

    private List<List<Integer>> result;
    private LinkedList<Integer> track;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        track = new LinkedList<>();
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int start) {
        result.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }
}
