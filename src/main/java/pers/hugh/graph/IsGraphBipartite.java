package pers.hugh.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author dingxiuzheng
 */
public class IsGraphBipartite {

    //785. Is Graph Bipartite?
    //https://leetcode.com/problems/is-graph-bipartite/


    //DFS

    private boolean[] visited;

    private boolean[] color;

    private boolean isBipartite;

    public boolean isBipartite(int[][] graph) {
        this.visited = new boolean[graph.length];
        this.color = new boolean[graph.length];
        this.isBipartite = true;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                traverse(graph, i, true);
            }
        }
        return this.isBipartite;
    }

    private void traverse(int[][] graph, int cur, boolean curColor) {
        if (!isBipartite) {
            return;
        }
        if (visited[cur]) {
            if (color[cur] != curColor) {
                this.isBipartite = false;
            }
            return;
        }
        visited[cur] = true;
        color[cur] = curColor;
        for (int next : graph[cur]) {
            traverse(graph, next, !curColor);
        }
    }

    public boolean isBipartite2(int[][] graph) {
        this.visited = new boolean[graph.length];
        this.color = new boolean[graph.length];
        this.isBipartite = true;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }
        return this.isBipartite;
    }

    private void traverse(int[][] graph, int cur) {
        if (!isBipartite) {
            return;
        }
        visited[cur] = true;
        for (int next : graph[cur]) {
            if (!visited[next]) {
                color[next] = !color[cur];
                traverse(graph, next);
            } else {
                if (color[next] == color[cur]) {
                    this.isBipartite = false;
                    return;
                }
            }
        }
    }

    //BFS
    public boolean isBipartite3(int[][] graph) {
        this.visited = new boolean[graph.length];
        this.color = new boolean[graph.length];
        this.isBipartite = true;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfs(graph, i);
            }
        }
        return this.isBipartite;
    }

    private void bfs(int[][] graph, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        color[start] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (visited[next]) {
                    if (color[next] == color[cur]) {
                        this.isBipartite = false;
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

    public static void main(String[] args) {
        IsGraphBipartite solution = new IsGraphBipartite();
        System.out.println(solution.isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
        System.out.println(solution.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
        System.out.println(solution.isBipartite2(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
        System.out.println(solution.isBipartite2(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
        System.out.println(solution.isBipartite3(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
        System.out.println(solution.isBipartite3(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
    }
}
