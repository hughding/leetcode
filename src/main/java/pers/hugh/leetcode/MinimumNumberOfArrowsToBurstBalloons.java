package pers.hugh.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hughding
 * @date 2020/9/2 11:37
 **/
public class MinimumNumberOfArrowsToBurstBalloons {
//
//    452. Minimum Number of Arrows to Burst Balloons
//
//    There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
//
//    An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.
//
//    题目描述：气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都被刺破。求解最小的投飞镖次数使所有气球都被刺破。
//
//    Example:
//
//    Input:
//            [[10,16], [2,8], [1,6], [7,12]]
//
//    Output:
//            2
//
//    Explanation:
//    One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).

    //求不重叠区间个数
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int count = 1;
        int[] pre = points[0];

        for (int i = 0; i < points.length; i++) {
            int[] cur = points[i];
            //由于已经排过序，所以必定cur[1] >= pre[1]
            if (pre[1] < cur[0]) {
                pre = cur;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons solution = new MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(solution.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }
}
