package pers.hugh.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dingxiuzheng
 */
public class CourseSchedule {

    //207. Course Schedule
    //https://leetcode.com/problems/course-schedule/

    //DFS

    private boolean[] visited;

    private boolean[] onPath;

    private boolean hasCycle;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        this.visited = new boolean[numCourses];
        this.onPath = new boolean[numCourses];
        this.hasCycle = false;
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return !hasCycle;
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
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1], to = prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }

    //BFS

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1], to = prerequisite[0];
            indegree[to]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            for (Integer next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();
        System.out.println(solution.canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
        System.out.println(solution.canFinish(3, new int[][]{{1, 0}, {2, 0}, {0, 2}}));
        System.out.println(solution.canFinish(20, new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}}));
        System.out.println(solution.canFinish(2, new int[][]{{0, 0}, {1, 1}}));
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));


        System.out.println(solution.canFinish2(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
        System.out.println(solution.canFinish2(3, new int[][]{{1, 0}, {2, 0}, {0, 2}}));
        System.out.println(solution.canFinish2(20, new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}}));
        System.out.println(solution.canFinish2(2, new int[][]{{0, 0}, {1, 1}}));
        System.out.println(solution.canFinish2(2, new int[][]{{1, 0}}));
        System.out.println(solution.canFinish2(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
