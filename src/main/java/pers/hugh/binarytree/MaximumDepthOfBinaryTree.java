package pers.hugh.binarytree;

/**
 * @author hughding
 * @date 2020/8/17 21:16
 **/
public class MaximumDepthOfBinaryTree {

    //104. Maximum Depth of Binary Tree
    //https://leetcode.com/problems/maximum-depth-of-binary-tree/

    public int maxDepth(TreeNode root) {
        return traverse(root);
    }

    public int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMaxDepth = traverse(node.left);
        int rightMaxDepth = traverse(node.right);
        int maxDepth = Math.max(leftMaxDepth, rightMaxDepth) + 1;
        return maxDepth;
    }
}
