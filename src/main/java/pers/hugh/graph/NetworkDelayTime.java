package pers.hugh.graph;

import java.util.*;

/**
 * @author dingxiuzheng
 */
public class NetworkDelayTime {
    //743. Network Delay Time
    //https://leetcode.com/problems/network-delay-time/

    private int[] timeTo;

    public int networkDelayTime(int[][] times, int n, int k) {
        k = k - 1;
        List<int[]>[] graph = buildGraph(times, n);
        timeTo = new int[n];
        Arrays.fill(timeTo, Integer.MAX_VALUE);
        Queue<State> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.timeFromStart));
        queue.offer(new State(k, 0));
        timeTo[k] = 0;
        while (!queue.isEmpty()) {
            State state = queue.poll();
            int cur = state.id;
            int timeFromStart = state.timeFromStart;

            for (int[] neighbor : graph[cur]) {
                int next = neighbor[0];
                int nextTimeFromStart = timeFromStart + neighbor[1];
                if (timeTo[next] > nextTimeFromStart) {
                    timeTo[next] = nextTimeFromStart;
                    queue.offer(new State(next, nextTimeFromStart));
                }
            }
        }
        int max = -1;
        for (int i = 0; i < timeTo.length; i++) {
            if (i == k) {
                continue;
            }
            if (timeTo[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, timeTo[i]);
        }
        return max;
    }

    private List<int[]>[] buildGraph(int[][] times, int n) {
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] time : times) {
            int from = time[0] - 1, to = time[1] - 1, cost = time[2];
            graph[from].add(new int[]{to, cost});
        }
        return graph;
    }

    private static class State {
        public int id;
        public int timeFromStart;

        public State(int id, int timeFromStart) {
            this.id = id;
            this.timeFromStart = timeFromStart;
        }
    }

    public static void main(String[] args) {
        NetworkDelayTime solution = new NetworkDelayTime();
        System.out.println(solution.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(solution.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1));
        System.out.println(solution.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));
    }
}
