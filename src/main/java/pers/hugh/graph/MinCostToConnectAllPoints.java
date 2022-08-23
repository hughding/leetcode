package pers.hugh.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class MinCostToConnectAllPoints {

    //1584. Min Cost to Connect All Points
    //https://leetcode.com/problems/min-cost-to-connect-all-points/
    //网页上写代码，本地无测试用例

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int x = 0; x < n; x++) {
            for (int y = x + 1; y < n; y++) {
                edges.add(new int[]{x, y, distance(points[x], points[y])});
            }
        }
        Collections.sort(edges, Comparator.comparingInt(a -> a[2]));
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], dis = edge[2];
            if (!uf.connected(from, to)) {
                cost += dis;
                uf.union(from, to);
            }
        }
        return cost;
    }

    private int distance(int[] point1, int[] point2) {
        int x1 = point1[0], y1 = point1[1];
        int x2 = point2[0], y2 = point2[1];
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
            }
        }

        public boolean connected(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            return rootP == rootQ;
        }

        public int findRoot(int x) {
            if (x == parent[x]) {
                return x;
            }
            parent[x] = findRoot(parent[x]);
            return parent[x];
        }
    }
}
