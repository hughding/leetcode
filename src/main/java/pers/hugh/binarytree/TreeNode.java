package pers.hugh.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hughding
 * @date 2020/6/29 19:52
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(Integer... arr) {
        TreeNode node = constract(arr, 0);
        this.val = node.val;
        this.left = node.left;
        this.right = node.right;
    }

    private static TreeNode constract(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }
        TreeNode left = constract(arr, index * 2 + 1);
        TreeNode right = constract(arr, index * 2 + 2);
        TreeNode node = new TreeNode(arr[index], left, right);
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        traverse(Arrays.asList(this), sb);
        return sb.toString();
    }

    private static void traverse(List<TreeNode> nodeList, StringBuilder sb) {
        if (nodeList.isEmpty()) {
            return;
        }
        List<TreeNode> nextNodeList = new ArrayList<>();
        for (TreeNode node : nodeList) {
            sb.append(node.val).append(" ");
            if (node.left != null) {
                nextNodeList.add(node.left);
            }
            if (node.right != null) {
                nextNodeList.add(node.right);
            }
        }
        sb.append("\n");
        traverse(nextNodeList, sb);
    }
}
