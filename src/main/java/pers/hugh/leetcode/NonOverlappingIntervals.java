package pers.hugh.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hughding
 * @date 2020/9/2 10:55
 **/
public class NonOverlappingIntervals {
//    435. Non-overlapping Intervals
//    Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
//
//
//
//            Example 1:
//
//    Input: [[1,2],[2,3],[3,4],[1,3]]
//    Output: 1
//    Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
//            Example 2:
//
//    Input: [[1,2],[1,2],[1,2]]
//    Output: 2
//    Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
//            Example 3:
//
//    Input: [[1,2],[2,3]]
//    Output: 0
//    Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
//
//
//            Note:
//
//    You may assume the interval's end point is always bigger than its start point.
//    Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int count = 0;
        int[] pre = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            //由于有排序，所以一定pre[1] <= cur[1]
            if (pre[1] > cur[0]) {
                count++;
            } else {
                pre = cur;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals solution = new NonOverlappingIntervals();
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
}
