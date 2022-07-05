package pers.hugh.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hughding
 * @date 2020/8/10 20:29
 **/
public class UniqueBinarySearchTreesII {

    //    Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
//
//    Example:
//
//    Input: 3
//    Output:
//            [
//            [1,null,3,2],
//            [3,2,null,1],
//            [3,1,null,null,2],
//            [2,1,3],
//            [1,null,2,null,3]
//            ]
//    Explanation:
//    The above output corresponds to the 5 unique BST's shown below:
//
//            1         3     3      2      1
//            \       /     /      / \      \
//            3     2     1      1   3      2
//            /     /       \                 \
//            2     1         2                 3

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {

        List<TreeNode> result = new ArrayList<>();
        if(start > end){
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> l = generate(start, i - 1);
            List<TreeNode> r = generate(i + 1, end);

            for (TreeNode ll : l) {
                for (TreeNode rr : r) {
                    TreeNode node = new TreeNode(i);
                    node.left = ll;
                    node.right = rr;
                    result.add(node);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII solution = new UniqueBinarySearchTreesII();
        List<TreeNode> result = solution.generateTrees(3);
        System.out.println(result);
    }
}
