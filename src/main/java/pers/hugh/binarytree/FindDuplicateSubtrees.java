package pers.hugh.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dingxiuzheng
 */
public class FindDuplicateSubtrees {

    //652. Find Duplicate Subtrees
    //https://leetcode.com/problems/find-duplicate-subtrees/

    //有可优化的空间，只用preorderCount，不用preorderNode
    private Map<String, TreeNode> preorderNode;
    private Map<String, Integer> preorderCount;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        preorderNode = new HashMap<>();
        preorderCount = new HashMap<>();
        find(root);
        List<TreeNode> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : preorderCount.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(preorderNode.get(entry.getKey()));
            }
        }
        return res;
    }

    public String find(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String rootVal = String.valueOf(root.val);
        String leftPreorder = find(root.left);
        String rightPreorder = find(root.right);
        String preorder = rootVal + "," + leftPreorder + "," + rightPreorder;
        preorderNode.put(preorder, root);
        preorderCount.put(preorder, preorderCount.getOrDefault(preorder, 0) + 1);
        return preorder;
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicateSubtrees().findDuplicateSubtrees(
                new TreeNode(1, 2, 3, 4, null, 2, 4, null, null, null, null, 4)));
        System.out.println(new FindDuplicateSubtrees().findDuplicateSubtrees(
                new TreeNode(2, 2, 2, 3, null, 3, null)));
    }
}
