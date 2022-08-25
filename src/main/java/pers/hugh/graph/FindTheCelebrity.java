package pers.hugh.graph;

/**
 * @author dingxiuzheng
 */
public class FindTheCelebrity {

    //VIP 收费题目
    //277. Find the Celebrity
    //https://leetcode.com/problems/find-the-celebrity/
    //名人：所有人都认识名人，名人不认识所有人

    //Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1people know him/her but he/she does not know any of them.
    //
    //Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
    //
    //You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
    //
    //Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.

    //名人：所有人都认识名人，名人不认识所有人， 名人定义保证了最多有1个名人，如果有两个，就不符合名人的定义
    //两两比较，一定能排除一个不是名人的人，全部比较完，一定剩下一个可能是名人的人。

    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (!relation.knows(candidate, i) && relation.knows(i, candidate)) {
                //c可能是名人，不做任何事。
            } else {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (relation.knows(i, candidate) && !relation.knows(candidate, i)) {
                    return candidate;
                }
            }
        }
        return -1;
    }

    //题目提供的调用, 用户只能看到knows方法

    private Relation relation;

    public static class Relation {

        private int[][] graph;

        public Relation(int[][] graph) {
            this.graph = graph;
        }

        public boolean knows(int i, int j) {
            return graph[i][j] > 0;
        }
    }

    public static void main(String[] args) {
        FindTheCelebrity solution = new FindTheCelebrity();
        solution.relation = new Relation(new int[][]{{1, 1, 1, 0}, {1, 1, 1, 1}, {0, 0, 1, 0}, {0, 0, 1, 1}});
        System.out.println(solution.findCelebrity(4));
    }
}
