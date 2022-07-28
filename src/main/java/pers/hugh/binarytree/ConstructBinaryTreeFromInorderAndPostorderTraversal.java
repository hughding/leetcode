package pers.hugh.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dingxiuzheng
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    //106. Construct Binary Tree from Inorder and Postorder Traversal
    //https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

    private Map<Integer, Integer> inorderValIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderValIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderValIndex.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int inIndex = inorderValIndex.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int rightSize = inEnd - inIndex;
        root.left = build(inorder, inStart, inIndex - 1, postorder, postStart, postEnd - rightSize - 1);
        root.right = build(inorder, inIndex + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(
                new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }
}
