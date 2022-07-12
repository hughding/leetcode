package pers.hugh.bfs;

import java.util.*;

/**
 * @author dingxiuzheng
 */
public class OpenTheLock {

    //752. Open the Lock
    //https://leetcode.com/problems/open-the-lock/

    //bfs
    public int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visitedSet = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (visitedSet.contains(cur)) {
                    continue;
                }
                if (deadendsSet.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }
                visitedSet.add(cur);
                for (int j = 0; j < 4; j++) {
                    String s1 = plusOne(cur, j);
                    String s2 = minusOne(cur, j);
                    queue.offer(s1);
                    queue.offer(s2);
                }
            }
            step++;
        }
        return -1;
    }

    public String plusOne(String s, int i) {
        char[] charArray = s.toCharArray();
        if (charArray[i] == '9') {
            charArray[i] = '0';
        } else {
            charArray[i] = (char) (charArray[i] + 1);
        }
        return String.valueOf(charArray);
    }

    public String minusOne(String s, int i) {
        char[] charArray = s.toCharArray();
        if (charArray[i] == '0') {
            charArray[i] = '9';
        } else {
            charArray[i] = (char) (charArray[i] - 1);
        }
        return String.valueOf(charArray);
    }

    //dfs backtrack 耗时过长

    private int minStep;

    public int openLock2(String[] deadends, String target) {
        minStep = Integer.MAX_VALUE;
        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        Map<String, Integer> visitedStepMap = new HashMap<>();
        backtrack("0000", target, deadendsSet, visitedStepMap, 0);
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

    public void backtrack(String cur, String target, Set<String> deadendsSet, Map<String, Integer> visitedStepMap, int step) {
        if (deadendsSet.contains(cur)) {
            return;
        }
        if (visitedStepMap.containsKey(cur) && visitedStepMap.get(cur) <= step) {
            return;
        }
        if (target.equals(cur)) {
            minStep = Math.min(minStep, step);
            return;
        }
        visitedStepMap.put(cur, step);
        char[] charArray = cur.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            String s1 = plusOne(cur, i);
            backtrack(s1, target, deadendsSet, visitedStepMap, step + 1);
            String s2 = minusOne(cur, i);
            backtrack(s2, target, deadendsSet, visitedStepMap, step + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new OpenTheLock().openLock(
                new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(new OpenTheLock().openLock2(
                new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(new OpenTheLock().openLock(
                new String[]{"8888"}, "0009"));
        System.out.println(new OpenTheLock().openLock2(
                new String[]{"8888"}, "0009"));
        System.out.println(new OpenTheLock().openLock(
                new String[]{"0000"}, "0009"));
        System.out.println(new OpenTheLock().openLock2(
                new String[]{"0000"}, "0009"));
    }
}
