package pers.hugh.graph;

/**
 * @author dingxiuzheng
 */
public class GraphValidTree {

    //VIP 收费题目
    //261 题「以图判树」
    //树判定 = Union-Find.union + Union-Find.connected
    //给你输入编号从0到n - 1的n个结点，和一个无向边列表edges（每条边用节点二元组表示），
    //请你判断输入的这些边组成的结构是否是一棵树。
    //是树的话，说明不能有环，说明新增一个连接的节点，不能和新增前的图是一个联通分量。

    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if (uf.connected(from, to)) {
                return false;
            }
            uf.union(from, to);
        }
        return true;
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

        private int findRoot(int x) {
            if (x == parent[x]) {
                return x;
            }
            parent[x] = findRoot(parent[x]);
            return parent[x];
        }
    }

    public static void main(String[] args) {
        GraphValidTree solution = new GraphValidTree();
        System.out.println(solution.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        System.out.println(solution.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
    }
}
