package pers.hugh.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class Combinations {

    //77. Combinations
    //https://leetcode.com/problems/combinations/

    private List<List<Integer>> result;
    private LinkedList<Integer> track;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        track = new LinkedList<>();
        backtrack(n, k, 1);
        return result;
    }

    public void backtrack(int n, int k, int start){
        if(track.size() == k){
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }
}
