package pers.hugh.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dingxiuzheng
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    //105. Construct Binary Tree from Preorder and Inorder Traversal
    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = build(preorder, 0, inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode build(int[] preorder, int preOrderIndex, int[] inorder, int inorderStart, int inorderEnd) {
        if (preOrderIndex >= preorder.length) {
            return null;
        }
        if (search(inorder, preorder[preOrderIndex], inorderStart, inorderEnd) == -1) {
            return null;
        }
        int now = preorder[preOrderIndex];
        TreeNode node = new TreeNode(now);
        int inOrderIndex = search(inorder, now, inorderStart, inorderEnd);
        int leftIndex = preOrderIndex + 1;
        int rightIndex = preOrderIndex + (inOrderIndex - inorderStart) + 1;

        node.left = build(preorder, leftIndex, inorder, inorderStart, inOrderIndex - 1);
        node.right = build(preorder, rightIndex, inorder, inOrderIndex + 1, inorderEnd);
        return node;
    }

    private int search(int[] inorder, int num, int inorderStart, int inorderEnd) {
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (num == inorder[i]) {
                return i;
            }
        }
        return -1;
    }


    private Map<Integer, Integer> inorderValIndex;

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        inorderValIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderValIndex.put(inorder[i], i);
        }
        return build2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build2(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int cur = preorder[preStart];
        TreeNode node = new TreeNode(cur);
        int inIndex = inorderValIndex.get(cur);
        int leftSize = inIndex - inStart;
        node.left = build2(preorder, preStart + 1, preStart + leftSize, inorder, inStart, inIndex - 1);
        node.right = build2(preorder, preStart + leftSize + 1, preEnd, inorder, inIndex + 1, inEnd);
        return node;
    }


    public static void main(String[] args) {
        System.out.println(new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(
                new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
        System.out.println(new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree2(
                new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
