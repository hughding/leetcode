package pers.hugh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hughding
 * @date 2020/8/19 20:08
 **/
public class ValidateBinarySearchTree {
//    Given a binary tree, determine if it is a valid binary search tree (BST).
//
//    Assume a BST is defined as follows:
//
//    The left subtree of a node contains only nodes with keys less than the node's key.
//    The right subtree of a node contains only nodes with keys greater than the node's key.
//    Both the left and right subtrees must also be binary search trees.
//
//
//    Example 1:
//
//            2
//            / \
//            1   3
//
//    Input: [2,1,3]
//    Output: true
//    Example 2:
//
//            5
//            / \
//            1   4
//            / \
//            3   6
//
//    Input: [5,1,4,null,null,3,6]
//    Output: false
//    Explanation: The root node's value is 5 but its right child's value is 4.

    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderList = inorderTraversal(root);
        boolean isValidBST = true;
        for (int i = 0; i < inorderList.size(); i++) {
            if(i < 1){
                continue;
            }
            if(inorderList.get(i) <= inorderList.get(i -1)){
                isValidBST = false;
                break;
            }
        }
        return isValidBST;
    }

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

    //有问题
    public boolean isValidBST2(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left != null && root.right == null){
            return root.val > root.left.val;
        }
        if(root.left == null && root.right != null){
            return root.val < root.right.val;
        }
        boolean curIsValid = root.val > root.left.val && root.val < root.right.val;
        return curIsValid && isValidBST2(root.left) && isValidBST2(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, null, null);
        root.left = new TreeNode(1, null, null);
        root.right = new TreeNode(3, null, null);

        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        System.out.println(solution.isValidBST(root));
        System.out.println(solution.isValidBST2(root));

        TreeNode root2 = new TreeNode(5, null, null);
        root2.left = new TreeNode(1, null, null);
        root2.right = new TreeNode(4, new TreeNode(3, null, null), new TreeNode(6, null, null));
        System.out.println(solution.isValidBST(root2));
        System.out.println(solution.isValidBST2(root2));
    }
}
