package pers.hugh.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dingxiuzheng
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    //889. Construct Binary Tree from Preorder and Postorder Traversal
    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

    private Map<Integer, Integer> postValIndex;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        postValIndex = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postValIndex.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart + 1 > preEnd) {
            return root;
        }
        int leftRootVal = preorder[preStart + 1];
        int leftRootPostIndex = postValIndex.get(leftRootVal);
        int leftSize = leftRootPostIndex - postStart + 1;
        root.left = build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, leftRootPostIndex);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, leftRootPostIndex + 1, postEnd);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new ConstructBinaryTreeFromPreorderAndPostorderTraversal().constructFromPrePost(
                new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1}));
    }
}
