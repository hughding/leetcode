package pers.hugh.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dingxiuzheng
 */
public class HouseRobberIII {

    //337. House Robber III
    //https://leetcode.com/problems/house-robber-iii/

    private Map<TreeNode, Integer> mem;

    public int rob(TreeNode root) {
        mem = new HashMap<>();
        return dp(root);
    }

    private int dp(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (mem.containsKey(node)) {
            return mem.get(node);
        }

        int nextVal = dp(node.left);
        nextVal += dp(node.right);

        int nextNextVal = 0;
        if (node.left != null) {
            nextNextVal += dp(node.left.left);
            nextNextVal += dp(node.left.right);
        }
        if (node.right != null) {
            nextNextVal += dp(node.right.left);
            nextNextVal += dp(node.right.right);
        }
        int res = Math.max(nextVal, node.val + nextNextVal);
        mem.put(node, res);
        return res;
    }


    private Map<TreeNode, Integer> dp;

    public int rob2(TreeNode root) {
        dp = new HashMap<>();
        dp2(root);
        return dp.get(root);
    }

    private void dp2(TreeNode node) {
        if (node == null) {
            return;
        }

        dp2(node.left);
        dp2(node.right);

        return;
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobberIII().rob(new TreeNode(3,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(3, null, new TreeNode(1)))));
        System.out.println(new HouseRobberIII().rob(new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(3)),
                new TreeNode(5, null, new TreeNode(1)))));
    }
}
