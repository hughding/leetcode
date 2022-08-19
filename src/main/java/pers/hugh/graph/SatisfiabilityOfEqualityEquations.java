package pers.hugh.graph;

/**
 * @author dingxiuzheng
 */
public class SatisfiabilityOfEqualityEquations {

    //990. Satisfiability of Equality Equations
    //https://leetcode.com/problems/satisfiability-of-equality-equations/

    public boolean equationsPossible(String[] equations) {
        //26个字母
        UnionFind unionFind = new UnionFind(26);
        for (String equation : equations) {
            char o = equation.charAt(1);
            if (o == '=') {
                char a = equation.charAt(0);
                char b = equation.charAt(3);
                unionFind.union(a - 'a', b - 'a');
            }
        }
        for (String equation : equations) {
            char o = equation.charAt(1);
            if (o == '!') {
                char a = equation.charAt(0);
                char b = equation.charAt(3);
                if (unionFind.connected(a - 'a', b - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class UnionFind {

        private int[] parent;

        private int count;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            this.count = 0;
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
            return this.count;
        }

        private int findRoot(int x) {
            if (parent[x] == x) {
                return x;
            }
            parent[x] = findRoot(parent[x]);
            return parent[x];
        }
    }

    public static void main(String[] args) {
        SatisfiabilityOfEqualityEquations solution = new SatisfiabilityOfEqualityEquations();
        System.out.println(solution.equationsPossible(new String[]{"a==b", "b!=a"}));
        System.out.println(solution.equationsPossible(new String[]{"b==a", "a==b"}));
        System.out.println(solution.equationsPossible(new String[]{"f==a", "a==b", "f!=e", "a==c", "b==e", "c==f"}));
    }
}
