package pers.hugh.binarytree;

/**
 * @author dingxiuzheng
 */
public class PopulatingNextRightPointersInEachNode {

    //116. Populating Next Right Pointers in Each Node
    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

    //遍历

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        traverse(null, root);
        return root;
    }

    private void traverse(Node pre, Node node) {
        if (node == null) {
            return;
        }
        if (pre != null) {
            pre.next = node;
        }
        if (pre != null) {
            traverse(pre.right, node.left);
        } else {
            traverse(null, node.left);
        }
        traverse(node.left, node.right);
    }

    public static void main(String[] args) {
        System.out.println(new PopulatingNextRightPointersInEachNode().connect(
                new Node(1, new Node(2, new Node(4), new Node(5), null),
                        new Node(3, new Node(6), new Node(7), null), null)));
    }
}
