package pers.hugh.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class Triangle {
//    120. Triangle
//
//    Given a triangle array, return the minimum path sum from top to bottom.
//
//    For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
//
//    Example 1:
//
//    Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//    Output: 11
//    Explanation: The triangle looks like:
//            2
//            3 4
//            6 5 7
//            4 1 8 3
//    The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
//    Example 2:
//
//    Input: triangle = [[-10]]
//    Output: -10
//
//
//    Constraints:
//
//            1 <= triangle.length <= 200
//    triangle[0].length == 1
//    triangle[i].length == triangle[i - 1].length + 1
//            -104 <= triangle[i][j] <= 104
//
//
//    Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?

    public int minimumTotal(List<List<Integer>> triangle) {
        return min(triangle, 0, 0);
    }

    public int min(List<List<Integer>> triangle, int row, int index) {
        if (row + 1 > triangle.size()) {
            return 0;
        }
        int path = triangle.get(row).get(index);
        path += Math.min(min(triangle, row + 1, index), min(triangle, row + 1, index + 1));
        return path;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> curRow = triangle.get(i);
            List<Integer> nextRow = triangle.get(i + 1);
            for (int j = 0; j < curRow.size(); j++) {
                int cur = curRow.get(j);
                curRow.set(j, cur + Math.min(nextRow.get(j), nextRow.get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

    //dp[r][i] = min(dp[r+1][i],dp[k][i+1]) + triangle[r][i]
    public int minimumTotal3(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        List<Integer> lastRow = triangle.get(triangle.size() -1);
        for (int i = 0; i < lastRow.size(); i++) {
            dp[i] = lastRow.get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> curRow = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + curRow.get(j);
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        System.out.println(new Triangle().minimumTotal(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3))));
        System.out.println(new Triangle().minimumTotal(Arrays.asList(Arrays.asList(-10))));
        System.out.println(new Triangle().minimumTotal2(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3))));
        System.out.println(new Triangle().minimumTotal2(Arrays.asList(Arrays.asList(-10))));
        System.out.println(new Triangle().minimumTotal3(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3))));
        System.out.println(new Triangle().minimumTotal3(Arrays.asList(Arrays.asList(-10))));
    }
}
