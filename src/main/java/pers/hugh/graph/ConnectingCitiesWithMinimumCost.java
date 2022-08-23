package pers.hugh.graph;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dingxiuzheng
 */
public class ConnectingCitiesWithMinimumCost {

    //VIP 收费题目
    //1135 题「最低成本联通所有城市」
    //Kruskal 算法（克鲁斯卡尔算法）= 树判定 + 权重排序
    //地图上有n个城市，以1-n编号。connections[i] = [city1, city2, cost]，将城市city1、city2连接的成本是cost。
    //计算连通所有城市最小成本， 如果无法连通所有城市，返回-1

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

    public static void main(String[] args) {
        ConnectingCitiesWithMinimumCost solution = new ConnectingCitiesWithMinimumCost();
        System.out.println(solution.minimumCost(3, new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}));
        System.out.println(solution.minimumCost(3, new int[][]{{1, 2, 5}}));
    }
}
