package pers.hugh.linkedlist;

/**
 * @author dingxiuzheng
 */
public class PartitionList {

    //86. Partition List
    //https://leetcode.com/problems/partition-list/
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();
        ListNode p = head;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p;
            } else {
                p1.next = p;
                p1 = p;
            }
            p = p.next;
        }
        p1.next = null;
        p2.next = null;
        p1.next = head2.next;
        return head1.next;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionList().partition(
                new ListNode(1, new ListNode(4, new ListNode(3,
                        new ListNode(2, new ListNode(5, new ListNode(2)))))), 3));
    }
}
