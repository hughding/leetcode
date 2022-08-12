package pers.hugh.binarytree;

/**
 * @author dingxiuzheng
 */
public class SearchInABinarySearchTree {

    //700. Search in a Binary Search Tree
    //https://leetcode.com/problems/search-in-a-binary-search-tree/
    //网页上写代码，本地无测试用例

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return null;
    }
}
