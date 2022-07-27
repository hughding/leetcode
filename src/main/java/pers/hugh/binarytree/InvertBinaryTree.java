package pers.hugh.binarytree;

/**
 * @author dingxiuzheng
 */
public class InvertBinaryTree {

    //226. Invert Binary Tree
    //https://leetcode.com/problems/invert-binary-tree/

    //分解问题
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    //遍历二叉树
    public TreeNode invertTree2(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        traverse(node.left);
        traverse(node.right);
    }

    public static void main(String[] args) {
        System.out.println(new InvertBinaryTree().invertTree(new TreeNode(4, 2, 7, 1, 3, 6, 9)));
        System.out.println(new InvertBinaryTree().invertTree(new TreeNode(2, 1, 3)));
        System.out.println(new InvertBinaryTree().invertTree2(new TreeNode(4, 2, 7, 1, 3, 6, 9)));
        System.out.println(new InvertBinaryTree().invertTree2(new TreeNode(2, 1, 3)));
    }
}