package pers.hugh.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hughding
 * @date 2020/8/17 21:16
 **/
public class UniqueBinarySearchTrees {

    //96. Unique Binary Search Trees
    //https://leetcode.com/problems/unique-binary-search-trees/

    private Map<Integer, Integer> mem;

    public int numTrees(int n) {
        mem = new HashMap<>();
        return num(1, n);
    }

    public int num(int start, int end) {
        if (start >= end) {
            return 1;
        }
        int key = end * 19 + start;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        int count = 0;
        for (int i = start; i <= end; i++) {
            int leftNum = num(start, i - 1);
            int rightNum = num(i + 1, end);
            count += leftNum * rightNum;
        }
        mem.put(key, count);
        return count;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();
        System.out.println(solution.numTrees(3));
        System.out.println(solution.numTrees(1));
        System.out.println(solution.numTrees(18));
    }
}
