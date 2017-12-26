package pers.hugh.dp;

/**
 * @author xzding
 * @version 1.0
 * @since <pre>2017/12/26</pre>
 */
public class TheTriangle {
//  北大POJ 1163
//  http://poj.org/problem?id=1163

    public int maxSum1(int[][] triangle, int r, int c) {
        if (r == triangle.length - 1) {
            return triangle[r][c];
        }
        int maxLeft = maxSum1(triangle, r + 1, c) + triangle[r][c];
        int maxRight = maxSum1(triangle, r + 1, c + 1) + triangle[r][c];
        return maxLeft > maxRight ? maxLeft : maxRight;
    }

    public int maxSum2(int[][] maxSum, int[][] triangle, int r, int c) {
        if (maxSum[r][c] != -1) {
            return maxSum[r][c];
        }
        if(r == triangle.length){
            maxSum[r][c] = triangle[r][c];
        }
        int maxLeft = maxSum2(maxSum, triangle, r + 1, c);
        int maxRight = maxSum2(maxSum, triangle, r + 1, c + 1);
        maxSum[r][c] =  maxLeft > maxRight ? maxLeft : maxRight + triangle[r][c];
        return maxSum[r][c];
    }


    public static void main(String[] args) {

        int[][] triangle = new int[][]{
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        int n = triangle.length;

        //solution 1
        System.out.println(new TheTriangle().maxSum1(triangle, 0, 0));

        int[][] maxSum = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxSum[i][j] = -1;
            }
        }
    }
}
