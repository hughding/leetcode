package pers.hugh.graph;

import java.util.*;

/**
 * @author dingxiuzheng
 */
public class CourseScheduleII {

    //210. Course Schedule II
    //https://leetcode.com/problems/course-schedule-ii/

    //DFS

    private boolean[] visited;

    private boolean[] onPath;

    private boolean hasCycle;

    private List<Integer> postorder;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        this.visited = new boolean[numCourses];
        this.onPath = new boolean[numCourses];
        this.hasCycle = false;
        this.postorder = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        if (hasCycle) {
            return new int[]{};
        }
        int[] res = new int[postorder.size()];
        for (int i = 0; i < postorder.size(); i++) {
            res[postorder.size() - i - 1] = postorder.get(i);
        }
        return res;
    }

    private void traverse(List<Integer>[] graph, int cur) {
        if (onPath[cur]) {
            hasCycle = true;
        }
        if (visited[cur] || hasCycle) {
            return;
        }
        visited[cur] = true;
        onPath[cur] = true;
        for (Integer next : graph[cur]) {
            traverse(graph, next);
        }
        onPath[cur] = false;
        postorder.add(cur);
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1], to = prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }


    //BFS

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1], to = prerequisite[0];
            indegree[to]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[count++] = cur;
            for (Integer next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (count < numCourses) {
            return new int[]{};
        }
        return res;
    }

    public static void main(String[] args) {
        CourseScheduleII solution = new CourseScheduleII();
        System.out.println(Arrays.toString(solution.findOrder(2, new int[][]{{0, 1}})));
        System.out.println(Arrays.toString(solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));

        System.out.println(Arrays.toString(solution.findOrder2(2, new int[][]{{0, 1}})));
        System.out.println(Arrays.toString(solution.findOrder2(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }
}
