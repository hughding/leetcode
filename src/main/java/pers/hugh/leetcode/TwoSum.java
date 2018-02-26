package pers.hugh.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xzding
 * @version 1.0
 * @since <pre>2018/2/26</pre>
 */
public class TwoSum {

//    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//            Example:
//    Given nums = [2, 7, 11, 15], target = 9,
//
//    Because nums[0] + nums[1] = 2 + 7 = 9,
//            return [0, 1].

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            if(map.containsKey(search) && map.get(search) != i){
                int index = map.get(search);
                if(i < index){
                    result[0] = i;
                    result[1] = index;
                }else{
                    result[0] = index;
                    result[1] = i;
                }
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = new TwoSum().twoSum(nums,target);
        System.out.println(result[0] + "," + result[1]);
        int[] nums2 = {3,2,4};
        int target2 = 6;
        int[] result2 = new TwoSum().twoSum(nums2,target2);
        System.out.println(result2[0] + "," + result2[1]);
    }
}
