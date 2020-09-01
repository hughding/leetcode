package pers.hugh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hughding
 * @date 2020/9/1 11:08
 **/
public class NQueens {
//
//    The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
//
//
//    Given an integer n, return all distinct solutions to the n-queens puzzle.
//
//    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
//    Example:
//
//    Input: 4
//    Output: [
//            [".Q..",  // Solution 1
//            "...Q",
//            "Q...",
//            "..Q."],
//
//            ["..Q.",  // Solution 2
//            "Q...",
//            "...Q",
//            ".Q.."]
//            ]
//    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

    public List<List<String>> solveNQueens(int n) {
        int[] flag = new int[n];
        List<List<String>> result = new ArrayList<>();
        solve(result, flag, 0);
        return result;
    }

    private void solve(List<List<String>> result, int[] flag, int row) {
        int n = flag.length;
        if (row == n) {
            result.add(parse(flag));
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean ok = true;
            if (row > 0){
                //和上行在同一列
                //和上行在对角线1
                //和上行在对角线2
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
                solve(result, flag, row + 1);
                flag[row] = 0;
            }
        }
    }

    private List<String> parse(int[] flag) {
        int n = flag.length;
        char[] fmt = new char[n];
        for (int i = 0; i < n; i++) {
            fmt[i] = '.';
        }

        List<String> result = new ArrayList<>();
        for (int col : flag) {
            fmt[col] = 'Q';
            result.add(String.valueOf(fmt));
            fmt[col] = '.';
        }
        return result;
    }

    public static void main(String[] args) {
        NQueens solution = new NQueens();
        printResult(solution.solveNQueens(4));
    }

    private static void printResult(List<List<String>> resultList) {
        System.out.println("resultList size = [" + resultList.size() + "]");
        for (List<String> result : resultList) {
            System.out.println("=====================");
            System.out.println(result);
        }
    }
}
