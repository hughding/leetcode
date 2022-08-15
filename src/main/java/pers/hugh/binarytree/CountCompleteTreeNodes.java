package pers.hugh.binarytree;

/**
 * @author dingxiuzheng
 */
public class CountCompleteTreeNodes {

    //222. Count Complete Tree Nodes
    //https://leetcode.com/problems/count-complete-tree-nodes/

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHigh = getLeftHigh(root);
        int rightHigh = getRightHigh(root);
        if (leftHigh == rightHigh) {
            return (int) (Math.pow(2, leftHigh) - 1);
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return 1 + leftCount + rightCount;
    }

    private int getLeftHigh(TreeNode node) {
        int i = 0;
        while (node != null) {
            i++;
            node = node.left;
        }
        return i;
    }

    private int getRightHigh(TreeNode node) {
        int i = 0;
        while (node != null) {
            i++;
            node = node.right;
        }
        return i;
    }

    public static void main(String[] args) {
        CountCompleteTreeNodes solution = new CountCompleteTreeNodes();
        System.out.println(solution.countNodes(new TreeNode(1, 2, 3, 4, 5, 6)));
    }
}
