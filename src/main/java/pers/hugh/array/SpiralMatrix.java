package pers.hugh.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class SpiralMatrix {

    //54. Spiral Matrix
    //https://leetcode.com/problems/spiral-matrix/submissions/

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int upBound = 0, downBound = m - 1;
        int leftBound = 0, rightBound = n - 1;

        while (res.size() < m * n) {
            if (upBound <= downBound) {
                for (int j = leftBound; j <= rightBound; j++) {
                    res.add(matrix[upBound][j]);
                }
                upBound++;
            }
            if (leftBound <= rightBound) {
                for (int i = upBound; i <= downBound; i++) {
                    res.add(matrix[i][rightBound]);
                }
                rightBound--;
            }
            if (upBound <= downBound) {
                for (int j = rightBound; j >= leftBound; j--) {
                    res.add(matrix[downBound][j]);
                }
                downBound--;
            }
            if (leftBound <= rightBound) {
                for (int i = downBound; i >= upBound; i--) {
                    res.add(matrix[i][leftBound]);
                }
                leftBound++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
