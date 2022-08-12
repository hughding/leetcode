package pers.hugh.binarytree;

/**
 * @author dingxiuzheng
 */
public class InsertIntoABinarySearchTree {

    //701. Insert into a Binary Search Tree
    //https://leetcode.com/problems/insert-into-a-binary-search-tree/
    //网页上写代码，本地无测试用例

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
