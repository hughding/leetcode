package pers.hugh.graph;

import java.util.*;

/**
 * @author dingxiuzheng
 */
public class MinCostToConnectAllPoints {

    //1584. Min Cost to Connect All Points
    //https://leetcode.com/problems/min-cost-to-connect-all-points/

    //Kruskal 算法（克鲁斯卡尔算法）= 树判定 + 权重排序
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

    //Prim算法
    public int minCostConnectPoints2(int[][] points) {
        List<int[]>[] graph = buildGraph(points);
        Prim prim = new Prim(graph);
        return prim.getWeightSum();
    }

    private List<int[]>[] buildGraph(int[][] points) {
        int n = points.length;
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    graph[i].add(new int[]{i, j, distance(points[i], points[j])});
                }
            }
        }
        return graph;
    }

    public static class Prim {
        private List<int[]>[] graph;
        private Queue<int[]> queue;
        private boolean[] inMST;
        private int weightSum;

        public Prim(List<int[]>[] graph) {
            this.graph = graph;
            this.queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
            this.inMST = new boolean[graph.length];
            this.weightSum = 0;
            cut(0);
            inMST[0] = true;
            while (!queue.isEmpty()) {
                int[] edge = queue.poll();
                int to = edge[1], weight = edge[2];
                if (!inMST[to]) {
                    cut(to);
                    weightSum += weight;
                    inMST[to] = true;
                }
            }
        }

        private void cut(int s) {
            for (int[] edge : graph[s]) {
                int to = edge[1];
                if (!inMST[to]) {
                    queue.offer(edge);
                }
            }
        }

        public int getWeightSum() {
            if (allConnected()) {
                return weightSum;
            } else {
                return -1;
            }
        }

        public boolean allConnected() {
            for (boolean in : inMST) {
                if (!in) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        MinCostToConnectAllPoints solution = new MinCostToConnectAllPoints();
        System.out.println(solution.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
        System.out.println(solution.minCostConnectPoints(new int[][]{{3, 12}, {-2, 5}, {-4, 1}}));
        System.out.println(solution.minCostConnectPoints2(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
        System.out.println(solution.minCostConnectPoints2(new int[][]{{3, 12}, {-2, 5}, {-4, 1}}));
    }
}
