package pers.hugh.binarytree;

/**
 * @author dingxiuzheng
 */
public class KthSmallestElementInABST {

    //230. Kth Smallest Element in a BST
    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    //直接在leetcode里写的代码，所以无测试用例

    private int count;

    private int res;

    public int kthSmallest(TreeNode root, int k) {
        this.count = 0;
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        if (++count == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
