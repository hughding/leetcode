package pers.hugh.dp;

/**
 * @author dingxiuzheng
 */
public class UniquePathsII {

//    63. Unique Paths II
//
//    You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or right at any point in time.
//
//    An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
//
//    Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
//
//    The testcases are generated so that the answer will be less than or equal to 2 * 109.
//
//
//
//    Example 1:
//
//
//    Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//    Output: 2
//    Explanation: There is one obstacle in the middle of the 3x3 grid above.
//    There are two ways to reach the bottom-right corner:
//            1. Right -> Right -> Down -> Down
//            2. Down -> Down -> Right -> Right
//
//
//    Example 2:
//
//
//    Input: obstacleGrid = [[0,1],[0,0]]
//    Output: 1
//
//
//    Constraints:
//
//    m == obstacleGrid.length
//    n == obstacleGrid[i].length
//    1 <= m, n <= 100
//    obstacleGrid[i][j] is 0 or 1.

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i > 0 && j > 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //i == 0
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }
}
