package pers.hugh.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class BinaryTreePreorderTraversal {

    //144. Binary Tree Preorder Traversal
    //https://leetcode.com/problems/binary-tree-preorder-traversal/

    //思路1：遍历二叉树
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    public void traverse(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        traverse(node.left, result);
        traverse(node.right, result);
    }

    //思路2：分解问题
    //一棵二叉树的前序遍历结果 = 根节点 + 左子树的前序遍历结果 + 右子树的前序遍历结果
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> preOrder = new ArrayList<>();
        preOrder.add(root.val);
        preOrder.addAll(preorderTraversal(root.left));
        preOrder.addAll(preorderTraversal(root.right));
        return preOrder;
    }
}
