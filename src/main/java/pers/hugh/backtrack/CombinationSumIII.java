package pers.hugh.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class CombinationSumIII {

    //216. Combination Sum III
    //https://leetcode.com/problems/combination-sum-iii/

    private List<List<Integer>> result;
    private LinkedList<Integer> track;
    private int sum;
    private int level;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        track = new LinkedList<>();
        sum = 0;
        level = 0;
        backtrack(k, n, 1);
        return result;
    }

    public void backtrack(int k, int n, int start) {
        if (level == k && sum == n) {
            result.add(new ArrayList<>(track));
            return;
        }
        if (level > k || sum > n) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            sum += i;
            level++;
            track.add(i);
            backtrack(k, n, i + 1);
            sum -= i;
            level--;
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIII().combinationSum3(3, 7));
        System.out.println(new CombinationSumIII().combinationSum3(3, 9));
    }
}
