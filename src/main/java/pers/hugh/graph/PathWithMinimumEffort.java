package pers.hugh.graph;

import java.util.*;

/**
 * @author dingxiuzheng
 */
public class PathWithMinimumEffort {

    //1631. Path With Minimum Effort
    //https://leetcode.com/problems/path-with-minimum-effort/

    private int[] effortTo;

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length * heights[0].length;
        List<int[]>[] graph = buildGraph(heights);
        effortTo = new int[n];
        Arrays.fill(effortTo, Integer.MAX_VALUE);
        Queue<State> queue = new PriorityQueue<>(Comparator.comparingInt(s -> s.effortFromStart));
        queue.offer(new State(0, 0));
        effortTo[0] = 0;
        while (!queue.isEmpty()) {
            State state = queue.poll();
            int cur = state.id;
            int effortFromStart = state.effortFromStart;
            for (int[] neighbor : graph[cur]) {
                int next = neighbor[0];
                int nextEffortFromStart = Math.max(neighbor[1], effortFromStart);
                if (effortTo[next] > nextEffortFromStart) {
                    effortTo[next] = nextEffortFromStart;
                    queue.offer(new State(next, nextEffortFromStart));
                }
            }
        }
        return effortTo[n - 1];
    }

    private List<int[]>[] buildGraph(int[][] heights) {
        int n = heights.length * heights[0].length;
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                int from = getIndex(i, j, heights[i].length);
                //下
                if (i != heights.length - 1) {
                    int to = getIndex(i + 1, j, heights[i].length);
                    int effort = Math.abs(heights[i + 1][j] - heights[i][j]);
                    graph[from].add(new int[]{to, effort});
                    graph[to].add(new int[]{from, effort});
                }
                //右
                if (j != heights[i].length - 1) {
                    int to = getIndex(i, j + 1, heights[i].length);
                    int effort = Math.abs(heights[i][j + 1] - heights[i][j]);
                    graph[from].add(new int[]{to, effort});
                    graph[to].add(new int[]{from, effort});
                }
            }
        }
        return graph;
    }

    public int getIndex(int r, int c, int cl) {
        return r * cl + c;
    }

    private static class State {
        public int id;
        public int effortFromStart;

        public State(int id, int effortFromStart) {
            this.id = id;
            this.effortFromStart = effortFromStart;
        }
    }

    public static void main(String[] args) {
        PathWithMinimumEffort solution = new PathWithMinimumEffort();
        System.out.println(solution.minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
        System.out.println(solution.minimumEffortPath(new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}));
        System.out.println(solution.minimumEffortPath(new int[][]{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}}));
    }
}
