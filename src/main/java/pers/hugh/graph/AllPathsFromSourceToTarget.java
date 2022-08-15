package pers.hugh.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class AllPathsFromSourceToTarget {

    //797. All Paths From Source to Target
    //https://leetcode.com/problems/all-paths-from-source-to-target/

    private List<List<Integer>> res;
    private LinkedList<Integer> onPath;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.res = new ArrayList<>();
        this.onPath = new LinkedList<>();
        traverse(graph, 0);
        return res;
    }

    private void traverse(int[][] graph, int cur) {
        onPath.add(cur);
        if (cur == graph.length - 1) {
            List<Integer> resItem = new ArrayList<>(onPath);
            res.add(resItem);
        }
        for (int i = 0; i < graph[cur].length; i++) {
            traverse(graph, graph[cur][i]);
        }
        onPath.removeLast();
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget solution = new AllPathsFromSourceToTarget();
        System.out.println(solution.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
    }
}
