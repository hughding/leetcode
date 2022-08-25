package pers.hugh.graph;

import java.util.*;

/**
 * @author dingxiuzheng
 */
public class PathWithMaximumProbability {

    //1514. Path with Maximum Probability
    //https://leetcode.com/problems/path-with-maximum-probability/

    private double[] probTo;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = buildGraph(n, edges, succProb);
        probTo = new double[n];
        Queue<State> queue = new PriorityQueue<>((a, b) -> Double.compare(b.probFromStart, a.probFromStart));
        queue.offer(new State(start, 1));
        probTo[start] = 1;

        while (!queue.isEmpty()) {
            State curState = queue.poll();
            int cur = curState.id;
            double probFromStart = curState.probFromStart;
            for (double[] neighbor : graph[cur]) {
                int next = (int) neighbor[0];
                double nextProb = neighbor[1];
                double nextProbFromStart = probFromStart * nextProb;
                if (probTo[next] < nextProbFromStart) {
                    probTo[next] = nextProbFromStart;
                    queue.offer(new State(next, nextProbFromStart));
                }
            }
        }
        return probTo[end];
    }

    public List<double[]>[] buildGraph(int n, int[][] edges, double[] succProb) {
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0], to = edge[1];
            double prob = succProb[i];
            graph[from].add(new double[]{to, prob});
            graph[to].add(new double[]{from, prob});
        }
        return graph;
    }

    private static class State {
        public int id;
        public double probFromStart;

        public State(int id, double probFromStart) {
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }

    public static void main(String[] args) {
        PathWithMaximumProbability solution = new PathWithMaximumProbability();
        System.out.println(solution.maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2}, 0, 2));
        System.out.println(solution.maxProbability(3, new int[][]{{0, 1}}, new double[]{0.5}, 0, 2));
    }
}
