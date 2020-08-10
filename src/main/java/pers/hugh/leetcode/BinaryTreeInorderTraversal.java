package pers.hugh.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @author hughding
 * @date 2020/6/2 21:29
 **/
public class BinaryTreeInorderTraversal {
//    Given a binary tree, return the inorder traversal of its nodes' values.
//
//    Example:
//
//    Input: [1,null,2,3]
//            1
//            \
//            2
//            /
//            3
//
//    Output: [1,3,2]
//    Follow up: Recursive solution is trivial, could you do it iteratively?

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            inorder(root.right, result);
        }
    }

    /**
     * 非递归算法,中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderNoRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }

        return result;
    }

    /**
     * 非递归算法,前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderNoRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }

        return result;
    }

    /**
     * 非递归算法,后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderNoRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode preMid = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (preMid != null) {
                stack.push(preMid);
            }
            preMid = stack.pop();
            if (preMid.right != null) {
                node = preMid.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        root.left = new TreeNode(4, null, new TreeNode(5, null, null));
        root.right = new TreeNode(2, new TreeNode(3, null, null), null);

        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        System.out.println(solution.inorderTraversal(root));
        System.out.println(solution.inorderNoRecursion(root));
        System.out.println(solution.postorderNoRecursion(root));
    }
}
