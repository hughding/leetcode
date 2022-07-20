package pers.hugh.linkedlist;

import java.util.Stack;

/**
 * @author dingxiuzheng
 */
public class ReverseLinkedListII {

    //92. Reverse Linked List II
    //https://leetcode.com/problems/reverse-linked-list-ii/

    private ListNode dummy;
    private ListNode tail;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode p = head;
        ListNode preP = dummyHead;
        int i = 1;
        while (p != null && i < left) {
            preP = p;
            p = p.next;
            i++;
        }
        ListNode res = reverse(p, i, right);
        res.next = tail;
        preP.next = dummy.next;
        return dummyHead.next;
    }

    private ListNode reverse(ListNode node, int current, int right) {
        if (current > right) {
            dummy = new ListNode();
            tail = node;
            return dummy;
        }
        ListNode preNode = reverse(node.next, current + 1, right);
        preNode.next = node;
        return node;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode q = dummy;
        ListNode p = head;
        int i = 1;
        while (p != null && i < left) {
            q.next = p;
            q = p;

            p = p.next;
            i++;
        }
        ListNode tail = null;
        Stack<ListNode> stack = new Stack<>();
        while (p != null && i >= left && i <= right) {
            stack.push(p);
            p = p.next;
            i++;
            tail = p;
        }

        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            q.next = node;
            q = q.next;
        }
        q.next = tail;
        return dummy.next;
    }


    public ListNode reverseBetween3(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween3(head.next, left - 1, right - 1);
        return head;
    }

    public ListNode reverseN(ListNode node, int n) {
        if (n == 1) {
            tail = node.next;
            return node;
        }
        ListNode last = reverseN(node.next, n - 1);
        node.next.next = node;
        node.next = tail;
        return last;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseLinkedListII().reverseBetween(new ListNode(1, 2, 3, 4, 5), 2, 4));
        System.out.println(new ReverseLinkedListII().reverseBetween(new ListNode(5), 1, 1));
        System.out.println(new ReverseLinkedListII().reverseBetween(new ListNode(3, 5), 1, 2));
        System.out.println(new ReverseLinkedListII().reverseBetween2(new ListNode(1, 2, 3, 4, 5), 2, 4));
        System.out.println(new ReverseLinkedListII().reverseBetween2(new ListNode(5), 1, 1));
        System.out.println(new ReverseLinkedListII().reverseBetween3(new ListNode(1, 2, 3, 4, 5), 2, 4));
        System.out.println(new ReverseLinkedListII().reverseBetween3(new ListNode(5), 1, 1));
    }
}
