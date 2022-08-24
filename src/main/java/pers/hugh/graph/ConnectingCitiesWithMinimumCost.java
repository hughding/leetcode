package pers.hugh.graph;

import java.util.*;

/**
 * @author dingxiuzheng
 */
public class ConnectingCitiesWithMinimumCost {

    //VIP 收费题目
    //1135 题「最低成本联通所有城市」
    //地图上有n个城市，以1-n编号。connections[i] = [city1, city2, cost]，将城市city1、city2连接的成本是cost。
    //计算连通所有城市最小成本， 如果无法连通所有城市，返回-1


    //Kruskal 算法（克鲁斯卡尔算法）= 树判定 + 权重排序
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
        UnionFind uf = new UnionFind(n);
        int res = 0;
        for (int[] connection : connections) {
            int from = connection[0] - 1, to = connection[1] - 1, cost = connection[2];
            if (!uf.connected(from, to)) {
                uf.union(from, to);
                res += cost;
            }
        }
        if (uf.getCount() > 1) {
            return -1;
        }
        return res;
    }

    public static class UnionFind {

        private int[] parent;

        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            count = n;
        }

        public void union(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
                count--;
            }
        }

        public boolean connected(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            return rootP == rootQ;
        }

        public int getCount() {
            return count;
        }

        private int findRoot(int x) {
            if (x == parent[x]) {
                return x;
            }
            parent[x] = findRoot(parent[x]);
            return parent[x];
        }
    }

    //Prim算法，切分
    public int minimumCost2(int n, int[][] connections) {
        List<int[]>[] graph = buildGraph(n, connections);
        Prim prim = new Prim(graph);
        return prim.getWeightSum();
    }

    private List<int[]>[] buildGraph(int n, int[][] connections) {
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] connection : connections) {
            int from = connection[0] - 1, to = connection[1] - 1, weight = connection[2];
            graph[from].add(new int[]{from, to, weight});
            graph[to].add(new int[]{to, from, weight});
        }
        return graph;
    }

    public static class Prim {

        private List<int[]>[] graph;

        private int weightSum;

        private Queue<int[]> queue;

        private boolean[] inMST;

        public Prim(List<int[]>[] graph) {
            this.graph = graph;
            this.weightSum = 0;
            this.queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
            this.inMST = new boolean[graph.length];

            cut(0);
            inMST[0] = true;
            while (!queue.isEmpty()) {
                int[] edge = queue.poll();
                int to = edge[1], weight = edge[2];
                if (!inMST[to]) {
                    weightSum += weight;
                    cut(to);
                    inMST[to] = true;
                }
            }
        }

        private void cut(int s) {
            for (int[] edge : graph[s]) {
                int to = edge[1];
                if (!inMST[to]) {
                    queue.add(edge);
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
        ConnectingCitiesWithMinimumCost solution = new ConnectingCitiesWithMinimumCost();
        System.out.println(solution.minimumCost(3, new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}));
        System.out.println(solution.minimumCost(3, new int[][]{{1, 2, 5}}));
        System.out.println(solution.minimumCost2(3, new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}));
        System.out.println(solution.minimumCost2(3, new int[][]{{1, 2, 5}}));
    }
}
