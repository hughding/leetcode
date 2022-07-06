package pers.hugh.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class Permutations {
    //46. Permutations
    //https://leetcode.com/problems/permutations/

    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            track.add(nums[i]);
            backtrack(nums, track, used);
            used[i] = false;
            track.remove(track.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1, 2, 3}));
        System.out.println(new Permutations().permute(new int[]{0, 1}));
        System.out.println(new Permutations().permute(new int[]{1}));
    }
}
