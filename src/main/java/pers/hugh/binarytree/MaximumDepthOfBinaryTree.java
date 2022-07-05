package pers.hugh.binarytree;

/**
 * @author hughding
 * @date 2020/8/17 21:16
 **/
public class MaximumDepthOfBinaryTree {

    //104. Maximum Depth of Binary Tree
    //https://leetcode.com/problems/maximum-depth-of-binary-tree/

    private int depth;
    private int result;

    //思路1：遍历二叉树
    public int maxDepth(TreeNode root) {
        traverse(root);
        return result;
    }

    public void traverse(TreeNode node) {
        if (node == null) {
            result = Math.max(result, depth);
            return;
        }
        depth++;
        traverse(node.left);
        traverse(node.right);
        depth--;
    }

    //思路2：分解问题
    //一棵二叉树的最大深度 = Max（左子树的最大深度，右子树的最大深度）
    public int maxDepth2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(node.left);
        int rightMaxDepth = maxDepth(node.right);
        int maxDepth = Math.max(leftMaxDepth, rightMaxDepth) + 1;
        return maxDepth;
    }
}
