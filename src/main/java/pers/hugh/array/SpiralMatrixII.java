package pers.hugh.array;

import java.util.Arrays;

/**
 * @author dingxiuzheng
 */
public class SpiralMatrixII {

    //59. Spiral Matrix II
    //https://leetcode.com/problems/spiral-matrix-ii/

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int upBound = 0, downBound = n - 1;
        int leftBound = 0, rightBound = n - 1;
        int num = 1;
        while (num <= n * n) {
            if (upBound <= downBound) {
                for (int j = leftBound; j <= rightBound; j++) {
                    matrix[upBound][j] = num;
                    num++;
                }
                upBound++;
            }
            if (leftBound <= rightBound) {
                for (int i = upBound; i <= downBound; i++) {
                    matrix[i][rightBound] = num;
                    num++;
                }
                rightBound--;
            }
            if (upBound <= downBound) {
                for (int j = rightBound; j >= leftBound; j--) {
                    matrix[downBound][j] = num;
                    num++;
                }
                downBound--;
            }
            if (leftBound <= rightBound) {
                for (int i = downBound; i >= upBound; i--) {
                    matrix[i][leftBound] = num;
                    num++;
                }
                leftBound++;
            }
        }
        return matrix;
    }

    private void print(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        spiralMatrixII.print(spiralMatrixII.generateMatrix(3));
        spiralMatrixII.print(spiralMatrixII.generateMatrix(1));
    }
}
