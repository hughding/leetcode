package pers.hugh.binarytree;

/**
 * @author dingxiuzheng
 */
public class LowestCommonAncestorOfABinarySearchTree {

    //235. Lowest Common Ancestor of a Binary Search Tree
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    //网页上写代码，本地无测试用例

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
