package pers.hugh.leetcode;

/**
 * @author hughding
 * @date 2020/8/17 21:16
 **/
public class UniqueBinarySearchTrees {

    //    Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
//
//    Example:
//
//    Input: 3
//    Output: 5
//    Explanation:
//    Given n = 3, there are a total of 5 unique BST's:
//
//            1         3     3      2      1
//            \       /     /      / \      \
//            3     2     1      1   3      2
//            /     /       \                 \
//            2     1         2                 3
//
//
//    Constraints:
//
//            1 <= n <= 19
    public int numTrees(int n) {
        return num(1, n);
    }

    public int num(int start, int end) {
        if (start >= end){
            return 1;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            int l = num(start, i - 1);
            int r = num(i + 1, end);
            sum += l * r;
        }
        return sum;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();
        System.out.println(solution.numTrees(3));
    }
}
