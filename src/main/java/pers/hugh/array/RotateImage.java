package pers.hugh.array;

import java.util.Arrays;

/**
 * @author dingxiuzheng
 */
public class RotateImage {

    //48. Rotate Image
    //https://leetcode.com/problems/rotate-image/

    public void rotate(int[][] matrix) {
        dp(matrix, 0);
    }

    public void dp(int[][] matrix, int start) {
        int n = matrix.length;
        if (start > n / 2) {
            return;
        }
        int end = n - start - 1;
        for (int i = start; i < end; i++) {
            //上->右
            int tmp1 = matrix[i][end];
            matrix[i][end] = matrix[start][i];
            //右->下
            int tmp2 = matrix[end][end - i + start];
            matrix[end][end - i + start] = tmp1;
            //下->左
            int tmp3 = matrix[end - i + start][start];
            matrix[end - i + start][start] = tmp2;
            //左->上
            matrix[start][i] = tmp3;
        }
        dp(matrix, start + 1);
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    private void print(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] matrix1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateImage.rotate(matrix1);
        rotateImage.print(matrix1);

        int[][] matrix2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateImage.rotate(matrix2);
        rotateImage.print(matrix2);

        int[][] matrix3 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateImage.rotate2(matrix3);
        rotateImage.print(matrix3);

        int[][] matrix4 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateImage.rotate2(matrix4);
        rotateImage.print(matrix4);
    }
}
