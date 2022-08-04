package pers.hugh.binarytree;

/**
 * @author dingxiuzheng
 */
public class ConvertBSTToGreaterTree {

    //538. Convert BST to Greater Tree
    //https://leetcode.com/problems/convert-bst-to-greater-tree/
    //1038. Binary Search Tree to Greater Sum Tree
    //https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
    //直接在leetcode里写的代码，所以无测试用例

    private int sum;

    public TreeNode convertBST(TreeNode root) {
        this.sum = 0;
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
