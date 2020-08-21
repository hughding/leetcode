package pers.hugh.dp;

/**
 * @author hughding
 * @date 2020/8/21 11:20
 **/
public class MinimumPathSum {
//    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
//    Note: You can only move either down or right at any point in time.
//
//            Example:
//
//    Input:
//            [
//              [1,3,1],
//            [1,5,1],
//            [4,2,1]
//            ]
//    Output: 7
//    Explanation: Because the path 1→3→1→1→1 minimizes the sum.

    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                }
                if (i > 0 && j == 0) {
                    dp[i][j] = dp[i - 1][0] + grid[i][0];
                }
                if (i == 0 && j > 0) {
                    dp[i][j] = dp[0][j - 1] + grid[0][j];
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }

        return dp[r - 1][c - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        MinimumPathSum solution = new MinimumPathSum();
        System.out.println(solution.minPathSum(grid));
    }
}
