package pers.hugh.linkedlist;

/**
 * @author dingxiuzheng
 */
public class MergeTwoSortedLists {
    //21. Merge Two Sorted Lists
    //https://leetcode.com/problems/merge-two-sorted-lists/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode head = new ListNode();
        ListNode p = head;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        if (p1 == null) {
            p.next = p2;
        }
        if (p2 == null) {
            p.next = p1;
        }
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(new MergeTwoSortedLists().mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4)))));
    }
}
