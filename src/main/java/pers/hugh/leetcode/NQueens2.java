package pers.hugh.leetcode;

/**
 * @author hughding
 * @date 2020/9/1 12:29
 **/
public class NQueens2 {

//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
//
//
//Given an integer n, return the number of distinct solutions to the n-queens puzzle.

    public int totalNQueens(int n) {
        int[] flag = new int[n];
        int[] count = new int[1];
        solve(count, flag, 0);
        return count[0];
    }

    private void solve(int[] count, int[] flag, int row) {
        int n = flag.length;
        if (row == n) {
            count[0]++;
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean ok = true;
            if (row > 0) {
                for (int j = 0; j < row; j++) {
                    if (flag[j] == i
                            || j + flag[j] == row + i
                            || j - flag[j] == row - i) {
                        ok = false;
                    }
                }
            }

            if (ok) {
                flag[row] = i;
                solve(count, flag, row + 1);
                flag[row] = 0;
            }
        }
    }

    public static void main(String[] args) {
        NQueens2 solution = new NQueens2();
        System.out.println(solution.totalNQueens(4));
    }
}
