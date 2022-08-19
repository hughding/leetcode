package pers.hugh.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {

    //VIP 收费题目
    //323 题「 无向图中连通分量的数目」
    //https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
    //给你输入一个包含 n 个节点的图，用一个整数 n 和一个数组 edges 表示，
    //其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间有一条边。请你计算这幅图的连通分量个数。

    //O(N)
    public int countComponents(int n, int[][] edges) {
        this.visited = new boolean[n];
        List<Integer>[] grid = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            grid[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            grid[from].add(to);
            grid[to].add(from);
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                traverse(grid, i);
            }
        }
        return components;
    }

    private boolean[] visited;

    private void traverse(List<Integer>[] grid, int cur) {
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        for (Integer next : grid[cur]) {
            traverse(grid, next);
        }
    }

    public int countComponents2(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }
        return unionFind.count();
    }

    //查并集（Union-Find）算法
    public static class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            this.count = n;
        }

        public void union(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);
            if (pRoot != qRoot) {
                parent[pRoot] = qRoot;
                count--;
            }
        }

        public boolean connected(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);
            return pRoot == qRoot;
        }

        public int count() {
            return count;
        }

        private int findRoot(int i) {
            if (parent[i] == i) {
                return i;
            }
            parent[i] = findRoot(parent[i]);
            return parent[i];
        }
    }

    public static void main(String[] args) {
        NumberOfConnectedComponentsInAnUndirectedGraph solution = new NumberOfConnectedComponentsInAnUndirectedGraph();
        System.out.println(solution.countComponents(4, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}}));
        System.out.println(solution.countComponents(10, new int[][]{{0, 1}, {2, 3}, {3, 4}}));
        System.out.println(solution.countComponents2(4, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}}));
        System.out.println(solution.countComponents2(10, new int[][]{{0, 1}, {2, 3}, {3, 4}}));
    }
}
