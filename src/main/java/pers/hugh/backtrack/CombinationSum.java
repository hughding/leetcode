package pers.hugh.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class CombinationSum {

    //39. Combination Sum
    //https://leetcode.com/problems/combination-sum/

    private List<List<Integer>> result;
    private LinkedList<Integer> track;
    private int sum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        track = new LinkedList<>();
        sum = 0;
        backtrack(candidates, target, 0);
        return result;
    }

    public void backtrack(int[] candidates, int target, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(track));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            sum += candidate;
            track.add(candidate);
            backtrack(candidates, target, i);
            sum -= candidate;
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 5, 3}, 8));
    }
}
