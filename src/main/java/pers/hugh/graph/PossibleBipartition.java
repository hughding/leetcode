package pers.hugh.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dingxiuzheng
 */
public class PossibleBipartition {

    //886. Possible Bipartition
    //https://leetcode.com/problems/possible-bipartition/

    //DFS

    private boolean[] visited;

    private boolean[] color;

    private boolean isBiPartite;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] grid = buildGraph(n, dislikes);
        this.visited = new boolean[n];
        this.color = new boolean[n];
        this.isBiPartite = true;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                traverse(grid, i, true);
            }
        }

        return this.isBiPartite;
    }

    private void traverse(List<Integer>[] grid, int cur, boolean curColor) {
        if (!isBiPartite) {
            return;
        }
        if (visited[cur]) {
            if (color[cur] != curColor) {
                isBiPartite = false;
            }
            return;
        }
        visited[cur] = true;
        color[cur] = curColor;
        for (Integer next : grid[cur]) {
            traverse(grid, next, !color[cur]);
        }
    }

    public boolean possibleBipartition2(int n, int[][] dislikes) {
        List<Integer>[] grid = buildGraph(n, dislikes);
        this.visited = new boolean[n];
        this.color = new boolean[n];
        this.isBiPartite = true;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                traverse(grid, i);
            }
        }
        return isBiPartite;
    }


    private void traverse(List<Integer>[] grid, int cur) {
        if (!isBiPartite) {
            return;
        }
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        for (Integer next : grid[cur]) {
            if (!visited[next]) {
                color[next] = !color[cur];
                traverse(grid, next);
            } else {
                if (color[next] == color[cur]) {
                    isBiPartite = false;
                    return;
                }
            }
        }
    }

    //BFS
    public boolean possibleBipartition3(int n, int[][] dislikes) {
        List<Integer>[] grid = buildGraph(n, dislikes);
        this.visited = new boolean[n];
        this.color = new boolean[n];
        this.isBiPartite = true;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(grid, i);
            }
        }

        return this.isBiPartite;
    }

    private void bfs(List<Integer>[] grid, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        color[start] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Integer next : grid[cur]) {
                if (visited[next]) {
                    if (color[next] == color[cur]) {
                        isBiPartite = false;
                        return;
                    }
                } else {
                    visited[next] = true;
                    color[next] = !color[cur];
                    queue.offer(next);
                }
            }
        }
    }


    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] grid = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            grid[i] = new LinkedList<>();
        }
        for (int[] dislike : dislikes) {
            int from = dislike[0] - 1, to = dislike[1] - 1;
            grid[from].add(to);
            grid[to].add(from);
        }
        return grid;
    }

    public static void main(String[] args) {
        PossibleBipartition solution = new PossibleBipartition();
        System.out.println(solution.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        System.out.println(solution.possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        System.out.println(solution.possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}));
        System.out.println(solution.possibleBipartition2(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        System.out.println(solution.possibleBipartition2(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        System.out.println(solution.possibleBipartition2(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}));
        System.out.println(solution.possibleBipartition3(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        System.out.println(solution.possibleBipartition3(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        System.out.println(solution.possibleBipartition3(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}));
    }
}
