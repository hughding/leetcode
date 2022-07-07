package pers.hugh.backtrack;

import java.util.*;

/**
 * @author dingxiuzheng
 */
public class SubsetsII {

    //90. Subsets II
    //https://leetcode.com/problems/subsets-ii/

    private List<List<Integer>> result;
    private LinkedList<Integer> track;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        track = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int start){
        result.add(new ArrayList<>(track));
        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
           if(!used.contains(nums[i])){
               track.add(nums[i]);
               backtrack(nums, i + 1);
               track.removeLast();
               used.add(nums[i]);
           }
        }
    }


    public static void main(String[] args) {
        System.out.println(new SubsetsII().subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(new SubsetsII().subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }
}
