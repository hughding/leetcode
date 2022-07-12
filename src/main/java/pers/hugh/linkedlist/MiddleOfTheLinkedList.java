package pers.hugh.linkedlist;

/**
 * @author dingxiuzheng
 */
public class MiddleOfTheLinkedList {

    //876. Middle of the Linked List
    //https://leetcode.com/problems/middle-of-the-linked-list/

    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null ) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        System.out.println(new MiddleOfTheLinkedList().middleNode(new ListNode(1, 2, 3, 4, 5)));
        System.out.println(new MiddleOfTheLinkedList().middleNode(new ListNode(1, 2, 3, 4, 5, 6)));
        System.out.println(new MiddleOfTheLinkedList().middleNode(new ListNode(1)));
        System.out.println(new MiddleOfTheLinkedList().middleNode(new ListNode(1, 2)));
    }
}
