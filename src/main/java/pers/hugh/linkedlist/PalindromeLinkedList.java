package pers.hugh.linkedlist;

/**
 * @author dingxiuzheng
 */
public class PalindromeLinkedList {

    //234. Palindrome Linked List
    //https://leetcode.com/problems/palindrome-linked-list/

    private ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    public boolean traverse(ListNode node) {
        if (node == null) {
            return true;
        }
        boolean res = traverse(node.next);
        boolean isPalindrome = res && left.val == node.val;
        left = left.next;
        return isPalindrome;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeLinkedList().isPalindrome(new ListNode(1, 2, 2, 1)));
        System.out.println(new PalindromeLinkedList().isPalindrome(new ListNode(1, 2, 3, 2, 1)));
        System.out.println(new PalindromeLinkedList().isPalindrome(new ListNode(1, 2)));
        System.out.println(new PalindromeLinkedList().isPalindrome(new ListNode(1)));
    }
}
