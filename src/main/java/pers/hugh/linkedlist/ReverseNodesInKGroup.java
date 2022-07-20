package pers.hugh.linkedlist;

import java.util.Stack;

/**
 * @author dingxiuzheng
 */
public class ReverseNodesInKGroup {

    //25. Reverse Nodes in k-Group
    //https://leetcode.com/problems/reverse-nodes-in-k-group/

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode q = dummy;

        ListNode p = head;
        int i = 0;
        Stack<ListNode> stack = new Stack<>();
        while (p != null) {
            if (i / k > 0 && i % k == 0) {
                while (!stack.isEmpty()) {
                    ListNode node = stack.pop();
                    q.next = node;
                    node.next = null;
                    q = q.next;
                }
            }
            stack.push(p);
            p = p.next;
            i++;
        }
        while (!stack.isEmpty()) {
            if (i % k == 0) {
                ListNode node = stack.pop();
                q.next = node;
                node.next = null;
                q = q.next;
            } else {
                ListNode node = stack.pop();
                q.next = node;
            }
        }
        return dummy.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode nodeA = head;
        ListNode nodeB = head;
        for (int i = 0; i < k; i++) {
            if (nodeB == null) {
                return head;
            }
            nodeB = nodeB.next;
        }
        ListNode res = reverse(nodeA, nodeB);
        nodeA.next = reverseKGroup2(nodeB, k);
        return res;
    }

    public ListNode reverse(ListNode nodeA, ListNode nodeB) {
        ListNode pre = null;
        ListNode cur = nodeA;
        ListNode next = null;
        while (cur != nodeB) {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseNodesInKGroup().reverseKGroup(new ListNode(1, 2, 3, 4, 5), 2));
        System.out.println(new ReverseNodesInKGroup().reverseKGroup(new ListNode(1, 2, 3, 4, 5), 3));
        System.out.println(new ReverseNodesInKGroup().reverseKGroup(new ListNode(1, 2), 2));
        System.out.println(new ReverseNodesInKGroup().reverseKGroup2(new ListNode(1, 2, 3, 4, 5), 2));
        System.out.println(new ReverseNodesInKGroup().reverseKGroup2(new ListNode(1, 2, 3, 4, 5), 3));
        System.out.println(new ReverseNodesInKGroup().reverseKGroup2(new ListNode(1, 2), 2));
    }
}
