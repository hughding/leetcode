package pers.hugh.array;

/**
 * @author dingxiuzheng
 */
public class RangeSumQuery2DImmutable {

    //304. Range Sum Query 2D - Immutable
    //https://leetcode.com/problems/range-sum-query-2d-immutable/

    static class NumMatrix {

        private int[][] preMatrix;

        public NumMatrix(int[][] matrix) {
            preMatrix = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                preMatrix[i][0] = 0;
            }
            for (int i = 0; i < matrix[0].length; i++) {
                preMatrix[0][i] = 0;
            }
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    preMatrix[row + 1][col + 1] = preMatrix[row + 1][col] + preMatrix[row][col + 1] + matrix[row][col] - preMatrix[row][col];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preMatrix[row2 + 1][col2 + 1] - preMatrix[row1][col2 + 1] - preMatrix[row2 + 1][col1] + preMatrix[row1][col1];
        }
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }

}
