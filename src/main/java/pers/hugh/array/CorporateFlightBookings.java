package pers.hugh.array;

import java.util.Arrays;

/**
 * @author dingxiuzheng
 */
public class CorporateFlightBookings {


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


    //1109. Corporate Flight Bookings
    //https://leetcode.com/problems/corporate-flight-bookings/

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference difference = new Difference(nums);
        for (int i = 0; i < bookings.length; i++) {
            int start = bookings[i][0] - 1;
            int end = bookings[i][1] - 1;
            int val = bookings[i][2];
            difference.increase(start, end, val);
        }
        return difference.result();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CorporateFlightBookings().corpFlightBookings(
                new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)));
        System.out.println(Arrays.toString(new CorporateFlightBookings().corpFlightBookings(
                new int[][]{{1, 2, 10}, {2, 2, 15}}, 2)));
    }
}
