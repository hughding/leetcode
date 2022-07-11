package pers.hugh.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class PermutationsII {

    //47. Permutations II
    //https://leetcode.com/problems/permutations-ii/

    private List<List<Integer>> result;
    private LinkedList<Integer> track;
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        track = new LinkedList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return result;
    }

    public void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            used[i] = true;
            track.add(nums[i]);
            backtrack(nums);
            used[i] = false;
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[]{1, 1, 2}));
        System.out.println(new PermutationsII().permuteUnique(new int[]{1, 2, 3}));
    }

}
