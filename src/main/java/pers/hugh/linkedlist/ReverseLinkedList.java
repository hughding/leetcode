package pers.hugh.linkedlist;

import java.util.Stack;

/**
 * @author dingxiuzheng
 */
public class ReverseLinkedList {

    //206. Reverse Linked List
    //https://leetcode.com/problems/reverse-linked-list/

    private ListNode dummy;

    public ListNode reverseList(ListNode head) {
        reverse(head);
        if (head != null) {
            head.next = null;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode node) {
        if (node == null) {
            dummy = new ListNode();
            return dummy;
        }
        ListNode preNode = reverse(node.next);
        preNode.next = node;
        return node;
    }

    public ListNode reverseList2(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode last = reverseList2(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }

    public ListNode reverseList3(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        ListNode dummy = new ListNode();
        p = dummy;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = null;
            p.next = node;
            p = p.next;
        }
        return dummy.next;
    }

    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode next = p.next;
        ListNode nextNext = p.next.next;
        ListNode newHead = null;
        while (p != null && next != null) {
            next.next = p;
            if (p == head) {
                p.next = null;
            }
            newHead = next;

            p = next;
            next = nextNext;
            if (next == null) {
                break;
            }
            nextNext = next.next;
        }

        return newHead;
    }

    public ListNode reverseList5(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseLinkedList().reverseList(new ListNode(1, 2, 3, 4, 5)));
        System.out.println(new ReverseLinkedList().reverseList(new ListNode(1, 2)));
        System.out.println(new ReverseLinkedList().reverseList(null));
        System.out.println(new ReverseLinkedList().reverseList2(new ListNode(1, 2, 3, 4, 5)));
        System.out.println(new ReverseLinkedList().reverseList2(new ListNode(1, 2)));
        System.out.println(new ReverseLinkedList().reverseList2(null));
        System.out.println(new ReverseLinkedList().reverseList3(new ListNode(1, 2, 3, 4, 5)));
        System.out.println(new ReverseLinkedList().reverseList3(new ListNode(1, 2)));
        System.out.println(new ReverseLinkedList().reverseList3(null));
        System.out.println(new ReverseLinkedList().reverseList4(new ListNode(1, 2, 3, 4, 5)));
        System.out.println(new ReverseLinkedList().reverseList4(new ListNode(1, 2)));
        System.out.println(new ReverseLinkedList().reverseList4(null));
        System.out.println(new ReverseLinkedList().reverseList5(new ListNode(1, 2, 3, 4, 5)));
        System.out.println(new ReverseLinkedList().reverseList5(new ListNode(1, 2)));
        System.out.println(new ReverseLinkedList().reverseList5(null));
    }
}
