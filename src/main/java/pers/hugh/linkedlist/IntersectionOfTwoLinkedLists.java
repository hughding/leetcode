package pers.hugh.linkedlist;

/**
 * @author dingxiuzheng
 */
public class IntersectionOfTwoLinkedLists {

    //160. Intersection of Two Linked Lists
    //https://leetcode.com/problems/intersection-of-two-linked-lists/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        boolean aTailed = false;
        boolean bTailed = false;
        while (true) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == null) {
                if (aTailed) {
                    return null;
                } else {
                    p1 = headB;
                    aTailed = true;
                }
            }
            if (p2 == null) {
                if (bTailed) {
                    return null;
                } else {
                    p2 = headA;
                    bTailed = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1, 2, 3, 4, 5);
        ListNode intersection = headA;
        while (intersection.val != 3) {
            intersection = intersection.next;
        }
        ListNode headB = new ListNode(11, new ListNode(22, new ListNode(33, intersection)));

        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(headA, headB).val);

        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(
                new ListNode(1, 2, 3),
                new ListNode(4, 5, 6)));

        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(headA, headA).val);
    }
}
