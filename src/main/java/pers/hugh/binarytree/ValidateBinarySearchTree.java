package pers.hugh.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hughding
 * @date 2020/8/19 20:08
 **/
public class ValidateBinarySearchTree {

    //98. Validate Binary Search Tree
    //https://leetcode.com/problems/validate-binary-search-tree/

    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderList = inorderTraversal(root);
        boolean isValidBST = true;
        for (int i = 0; i < inorderList.size(); i++) {
            if (i < 1) {
                continue;
            }
            if (inorderList.get(i) <= inorderList.get(i - 1)) {
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

    //尚未完全理解
    public boolean isValidBST2(TreeNode root) {
        return traverseIsValidBST(root, null, null);
    }

    /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */

    private boolean traverseIsValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return traverseIsValidBST(root.left, min, root) && traverseIsValidBST(root.right, root, max);
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
