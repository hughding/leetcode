package pers.hugh.leetcode;

/**
 * @author xzding
 * @version 1.0
 * @since <pre>2018/2/27</pre>
 */
public class AddTwoNumbers {
//    You are given two non-empty linked lists representing two non-negative integers.
//    The digits are stored in reverse order and each of their nodes contain a single digit.
//    Add the two numbers and return it as a linked list.
//
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

//    Example
//
//    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Output: 7 -> 0 -> 8
//    Explanation: 342 + 465 = 807.

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //两数之和
        int sum = l1.val + l2.val;
        //两数之和个位
        final ListNode result = new ListNode(sum % 10);
        ListNode current = result;
        //两位之和进位
        int carry = sum / 10;

        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            sum = l1.val + l2.val + carry;
            current.next = new ListNode(sum % 10);
            current = current.next;
            carry = sum / 10;
        }

        if (l1.next == null && l2.next == null) {
        } else if (l1.next == null) {
            while (l2.next != null) {
                l2 = l2.next;
                sum = carry + l2.val;
                current.next = new ListNode(sum % 10);
                current = current.next;
                carry = sum / 10;
            }
        } else {
            while (l1.next != null) {
                l1 = l1.next;
                sum = carry + l1.val;
                current.next = new ListNode(sum % 10);
                current = current.next;
                carry = sum / 10;
            }
        }
        if(carry != 0){
            current.next = new ListNode(carry);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(parse2String(new AddTwoNumbers().addTwoNumbers(l1,l2)));

        ListNode ll1 = new ListNode(9);
        ll1.next = new ListNode(9);
        ll1.next.next = new ListNode(9);
        ListNode ll2 = new ListNode(1);
        System.out.println(parse2String(new AddTwoNumbers().addTwoNumbers(ll1,ll2)));
    }

    public static String parse2String(ListNode l){
        StringBuilder sb = new StringBuilder(16);
        while(l != null){
            sb.append(l.val).append("->");
            l = l.next;
        }
        return sb.toString();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
