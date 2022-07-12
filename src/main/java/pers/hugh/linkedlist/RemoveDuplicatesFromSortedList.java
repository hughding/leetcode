package pers.hugh.linkedlist;

/**
 * @author dingxiuzheng
 * @see pers.hugh.array.RemoveDuplicatesFromSortedArray
 */
public class RemoveDuplicatesFromSortedList {

    //83. Remove Duplicates from Sorted List
    //same as RemoveDuplicatesFromSortedArray
    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/

    public ListNode deleteDuplicates(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }else{
                slow.next = fast.next;
            }
            fast = fast.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedList().deleteDuplicates(new ListNode(1, 1, 2)));
        System.out.println(new RemoveDuplicatesFromSortedList().deleteDuplicates(new ListNode(1, 1, 2, 3, 3)));
    }

}
