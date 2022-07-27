package pers.hugh.binarytree;

/**
 * @author dingxiuzheng
 */
public class FlattenBinaryTreeToLinkedList {

    //114. Flatten Binary Tree to Linked List
    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/


    //遍历
    private TreeNode p;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode dummy = new TreeNode();
        p = dummy;
        traverse(root);
        root.left = null;
        root.right = dummy.right.right;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        p.right = new TreeNode(node.val);
        p = p.right;
        traverse(node.left);
        traverse(node.right);
    }

    //分解问题1
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode res = f(root);
        root.left = null;
        root.right = res.right;
    }

    private TreeNode f(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = f(node.left);
        TreeNode right = f(node.right);
        if (left != null) {
            TreeNode p = left;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;
            return new TreeNode(node.val, null, left);
        }
        return new TreeNode(node.val, null, right);
    }

    //分解问题2
    public void flatten3(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten3(root.left);
        flatten3(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList flatten = new FlattenBinaryTreeToLinkedList();
        TreeNode t1 = new TreeNode(1, 2, 5, 3, 4, null, 6);
        flatten.flatten(t1);
        System.out.println(t1);
        TreeNode t2 = new TreeNode(1, 2, 5, 3, 4, null, 6);
        flatten.flatten2(t2);
        System.out.println(t2);
        TreeNode t3 = new TreeNode(1, 2, 5, 3, 4, null, 6);
        flatten.flatten3(t3);
        System.out.println(t3);
    }
}
