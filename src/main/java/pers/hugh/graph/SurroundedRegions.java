package pers.hugh.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class SurroundedRegions {

    //130. Surrounded Regions
    //https://leetcode.com/problems/surrounded-regions/


    //DFS
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        List<Integer> edgeOList = new ArrayList<>();
        for (int c = 0; c < n; c++) {
            if (board[0][c] == 'O') {
                edgeOList.add(0 * 200 + c);
            }
            if (board[m - 1][c] == 'O') {
                edgeOList.add((m - 1) * 200 + c);
            }
        }
        for (int r = 1; r < m - 1; r++) {
            if (board[r][0] == 'O') {
                edgeOList.add(r * 200 + 0);
            }
            if (board[r][n - 1] == 'O') {
                edgeOList.add(r * 200 + n - 1);
            }
        }
        for (Integer index : edgeOList) {
            int row = index / 200, col = index % 200;
            traverse(board, row, col);
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if (board[r][c] == '#') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void traverse(char[][] board, int r, int c) {
        if (board[r][c] != 'O') {
            return;
        }
        board[r][c] = '#';
        //上
        if (r - 1 >= 0) {
            traverse(board, r - 1, c);
        }
        //下
        if (r + 1 < board.length) {
            traverse(board, r + 1, c);
        }
        //左
        if (c - 1 >= 0) {
            traverse(board, r, c - 1);
        }
        //右
        if (c + 1 < board[0].length) {
            traverse(board, r, c + 1);
        }
    }

    public void solve2(char[][] board) {
        int m = board.length, n = board[0].length;
        NumberOfConnectedComponentsInAnUndirectedGraph.UnionFind unionFind
                = new NumberOfConnectedComponentsInAnUndirectedGraph.UnionFind(m * n + 1);
        for (int c = 0; c < n; c++) {
            if (board[0][c] == 'O') {
                unionFind.union(0 * n + c, m * n);
            }
            if (board[m - 1][c] == 'O') {
                unionFind.union((m - 1) * n + c, m * n);
            }
        }
        for (int r = 1; r < m - 1; r++) {
            if (board[r][0] == 'O') {
                unionFind.union(r * n + 0, m * n);
            }
            if (board[r][n - 1] == 'O') {
                unionFind.union(r * n + n - 1, m * n);
            }
        }
        for (int r = 1; r < m - 1; r++) {
            for (int c = 1; c < n - 1; c++) {
                if (board[r][c] == 'O') {
                    if (board[r - 1][c] == 'O') {
                        unionFind.union(r * n + c, (r - 1) * n + c);
                    }
                    if (board[r + 1][c] == 'O') {
                        unionFind.union(r * n + c, (r + 1) * n + c);
                    }
                    if (board[r][c - 1] == 'O') {
                        unionFind.union(r * n + c, r * n + c - 1);
                    }
                    if (board[r][c + 1] == 'O') {
                        unionFind.union(r * n + c, r * n + c + 1);
                    }
                }
            }
        }

        for (int r = 1; r < m - 1; r++) {
            for (int c = 1; c < n - 1; c++) {
                if (!unionFind.connected(r * n + c, m * n)) {
                    board[r][c] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions solution = new SurroundedRegions();
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solution.solve(board);
        System.out.println(board);
        char[][] board2 = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solution.solve2(board2);
        System.out.println(board2);
    }
}
