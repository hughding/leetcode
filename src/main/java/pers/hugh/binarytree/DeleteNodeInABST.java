package pers.hugh.binarytree;

/**
 * @author dingxiuzheng
 */
public class DeleteNodeInABST {

    //450. Delete Node in a BST
    //https://leetcode.com/problems/delete-node-in-a-bst/
    //网页上写代码，本地无测试用例

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = getMin(root.right);
            minNode.right = deleteNode(root.right, minNode.val);
            minNode.left = root.left;
            return minNode;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
