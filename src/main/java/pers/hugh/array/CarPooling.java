package pers.hugh.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dingxiuzheng
 */
public class CarPooling {

    //1094. Car Pooling
    //https://leetcode.com/problems/car-pooling/

    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < trips.length; i++) {
            int num = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];
            for (int j = start; j < end; j++) {
                map.put(j, map.getOrDefault(j, 0) + num);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > capacity) {
                return false;
            }
        }
        return true;
    }


    static class Difference {
        private int[] diff;

        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increase(int start, int end, int val) {
            diff[start] += val;
            if (end + 1 < diff.length) {
                diff[end + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < res.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }

    public boolean carPooling2(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference difference = new Difference(nums);
        for (int i = 0; i < trips.length; i++) {
            int num = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2] - 1;
            difference.increase(start, end, num);
        }
        nums = difference.result();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CarPooling().carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
        System.out.println(new CarPooling().carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
        System.out.println(new CarPooling().carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3));
        System.out.println(new CarPooling().carPooling2(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
        System.out.println(new CarPooling().carPooling2(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
        System.out.println(new CarPooling().carPooling2(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3));
    }
}
