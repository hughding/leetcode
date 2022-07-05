package pers.hugh.binarytree;

/**
 * @author dingxiuzheng
 */
public class DiameterOfBinaryTree {

    //543. Diameter of Binary Tree
    //https://leetcode.com/problems/diameter-of-binary-tree/

    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxDiameter;
    }

    public int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMaxDepth = traverse(node.left);
        int rightMaxDepth = traverse(node.right);
        int myDiameter = leftMaxDepth + rightMaxDepth;
        maxDiameter = Math.max(myDiameter, maxDiameter);
        int maxDepth = Math.max(leftMaxDepth, rightMaxDepth) + 1;
        return maxDepth;
    }
}
