package pers.hugh.linkedlist;

/**
 * @author dingxiuzheng
 */
public class RemoveNthNodeFromEndOfList {

    //19. Remove Nth Node From End of List
    //https://leetcode.com/problems/remove-nth-node-from-end-of-list/

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (n > 0) {
            p2 = p2.next;
            n--;
        }
        ListNode p1Pre = null;
        while (p2 != null) {
            p1Pre = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1Pre != null) {
            p1Pre.next = p1.next;
            return head;
        } else {
            return p1.next;
        }
    }

    public static void main(String[] args) {
        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(
                new ListNode(1, new ListNode(2, new ListNode(3,
                        new ListNode(4, new ListNode(5))))), 2));
        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(
                new ListNode(1), 1));
        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(
                new ListNode(1, new ListNode(2)), 2));
    }
}
