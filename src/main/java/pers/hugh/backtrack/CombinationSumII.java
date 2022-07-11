package pers.hugh.backtrack;

import javax.naming.CompositeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class CombinationSumII {
    //40. Combination Sum II
    //https://leetcode.com/problems/combination-sum-ii/

    private List<List<Integer>> result;
    private LinkedList<Integer> track;
    private int sum;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        track = new LinkedList<>();
        sum = 0;
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return result;
    }

    public void backtrack(int[] candidates, int target, int start) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if ( i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            track.add(candidates[i]);
            backtrack(candidates, target, i + 1);
            sum -= candidates[i];
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumII().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(new CombinationSumII().combinationSum2(
                new int[]{14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12}, 27));
    }
}
