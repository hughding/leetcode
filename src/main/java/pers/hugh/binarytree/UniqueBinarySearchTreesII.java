package pers.hugh.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hughding
 * @date 2020/8/10 20:29
 **/
public class UniqueBinarySearchTreesII {

    //    Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
//
//    Example:
//
//    Input: 3
//    Output:
//            [
//            [1,null,3,2],
//            [3,2,null,1],
//            [3,1,null,null,2],
//            [2,1,3],
//            [1,null,2,null,3]
//            ]
//    Explanation:
//    The above output corresponds to the 5 unique BST's shown below:
//
//            1         3     3      2      1
//            \       /     /      / \      \
//            3     2     1      1   3      2
//            /     /       \                 \
//            2     1         2                 3

    //95. Unique Binary Search Trees II
    //https://leetcode.com/problems/unique-binary-search-trees-ii/

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    public List<TreeNode> generate(int low, int high) {
        List<TreeNode> res = new ArrayList<>();
        if (low > high) {
            res.add(null);
            return res;
        }
        if (low == high) {
            res.add(new TreeNode(low));
            return res;
        }
        for (int i = low; i <= high; i++) {
            List<TreeNode> leftList = generate(low, i - 1);
            List<TreeNode> rightList = generate(i + 1, high);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i, left, right);
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII solution = new UniqueBinarySearchTreesII();
        List<TreeNode> result = solution.generateTrees(3);
        System.out.println(result);
    }
}
