package pers.hugh.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null){
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

    public static void main(String[] args) throws InterruptedException {
    }
}
