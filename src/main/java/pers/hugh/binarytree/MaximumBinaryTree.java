package pers.hugh.binarytree;

/**
 * @author dingxiuzheng
 */
public class MaximumBinaryTree {

    //654. Maximum Binary Tree
    //https://leetcode.com/problems/maximum-binary-tree/

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = build(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = build(nums, start, maxIndex - 1);
        node.right = build(nums, maxIndex + 1, end);
        return node;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
        System.out.println(new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1}));
    }
}
