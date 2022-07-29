package pers.hugh.binarytree;

import java.util.*;

/**
 * @author dingxiuzheng
 */
public class SerializeAndDeserializeBinaryTree {

    //297. Serialize and Deserialize Binary Tree
    //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preOrder(root, sb);
            return sb.substring(0, sb.length() - 1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] preArr = data.split(",");
            LinkedList<String> list = new LinkedList<>(Arrays.asList(preArr));
            return build(list);
        }

        private void preOrder(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("#").append(",");
                return;
            }
            sb.append(node.val).append(",");
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }

        public TreeNode build(LinkedList<String> list) {
            if (list.isEmpty()) {
                return null;
            }
            String rootVal = list.removeFirst();
            if ("#".equals(rootVal)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(rootVal));
            root.left = build(list);
            root.right = build(list);
            return root;
        }
    }

    static class Codec2 {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            postOrder(root, sb);
            return sb.substring(0, sb.length() - 1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] preArr = data.split(",");
            LinkedList<String> list = new LinkedList<>(Arrays.asList(preArr));
            return build(list);
        }

        private void postOrder(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("#").append(",");
                return;
            }
            postOrder(node.left, sb);
            postOrder(node.right, sb);
            sb.append(node.val).append(",");
        }

        public TreeNode build(LinkedList<String> list) {
            if (list.peekFirst() == null) {
                return null;
            }
            String rootVal = list.removeLast();
            if ("#".equals(rootVal)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(rootVal));
            root.right = build(list);
            root.left = build(list);
            return root;
        }
    }

    static class Codec3 {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("#").append(",");
                    continue;
                }
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
            return sb.substring(0, sb.length() - 1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("".equals(data)) {
                return null;
            }
            String[] levelArr = data.split(",");
            TreeNode root = new TreeNode(Integer.valueOf(levelArr[0]));
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int i = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                String leftVal = levelArr[i++];
                if (!"#".equals(leftVal)) {
                    node.left = new TreeNode(Integer.valueOf(leftVal));
                    queue.offer(node.left);
                }
                String rightVal = levelArr[i++];
                if (!"#".equals(rightVal)) {
                    node.right = new TreeNode(Integer.valueOf(rightVal));
                    queue.offer(node.right);
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1, 2, 3, null, null, 4, 5);
        TreeNode t2 = new TreeNode(1, 2, 2);
        Codec codec = new Codec();
        Codec2 codec2 = new Codec2();
        Codec3 codec3 = new Codec3();
        System.out.println(codec.deserialize(codec.serialize(t1)));
        System.out.println(codec.deserialize(codec.serialize(t2)));
        System.out.println(codec.deserialize(codec.serialize(null)));
        System.out.println(codec2.deserialize(codec2.serialize(t1)));
        System.out.println(codec2.deserialize(codec2.serialize(t2)));
        System.out.println(codec2.deserialize(codec2.serialize(null)));
        System.out.println(codec3.deserialize(codec3.serialize(t1)));
        System.out.println(codec3.deserialize(codec3.serialize(t2)));
        System.out.println(codec3.deserialize(codec3.serialize(null)));
    }
}
