package pers.hugh.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author dingxiuzheng
 */
public class MinimumDepthOfBinaryTree {

    //111. Minimum Depth of Binary Tree
    //https://leetcode.com/problems/minimum-depth-of-binary-tree/

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(
                new TreeNode(3, new TreeNode(9, null, null),
                        new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)))));
    }
}
