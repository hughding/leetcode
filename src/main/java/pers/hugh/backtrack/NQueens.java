package pers.hugh.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
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
            if (row > 0) {
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


    //回溯法
    List<List<String>> resultList;

    public List<List<String>> solveNQueens2(int n) {
        resultList = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(n, board, 0);
        return resultList;
    }

    public void backtrack(int n, char[][] board, int row) {
        if (row == n) {
            List<String> result = new ArrayList<>();
            for (char[] boardRow : board) {
                result.add(String.valueOf(boardRow));
            }
            resultList.add(result);
        }

        for (int i = 0; i < n; i++) {
            //校验无效位置
            if (!isValid(board, row, i)) {
                continue;
            }
            board[row][i] = 'Q';
            backtrack(n, board, row + 1);
            board[row][i] = '.';
        }

    }

    public boolean isValid(char[][] board, int row, int col) {
        //校验正上方
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //校验左上方
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        //校验右上方
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < board[i].length) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens solution = new NQueens();
        printResult(solution.solveNQueens(4));
        printResult(solution.solveNQueens2(4));
    }

    private static void printResult(List<List<String>> resultList) {
        System.out.println("resultList size = [" + resultList.size() + "]");
        for (List<String> result : resultList) {
            System.out.println("=====================");
            System.out.println(result);
        }
    }
}
