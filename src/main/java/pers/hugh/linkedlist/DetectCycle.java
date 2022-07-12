package pers.hugh.linkedlist;

/**
 * @author dingxiuzheng
 */
public class DetectCycle {

    //寻找环的起点
    public ListNode detectCycle(ListNode head) {
        if (!hasCycle(head)) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode cycle1 = new ListNode(1, 2, 3, 4, 5, 6);
        ListNode p = cycle1;
        ListNode cycleStart = cycle1;
        while (p != null) {
            if (p.val == 3) {
                cycleStart = p;
            }
            if (p.val == 6) {
                p.next = cycleStart;
                break;
            }
            p = p.next;
        }
        ListNode cycle2 = new ListNode(1, 2, 3, 4, 5, 6, 7);
        p = cycle2;
        cycleStart = cycle2;
        while (p != null) {
            if (p.val == 3) {
                cycleStart = p;
            }
            if (p.val == 7) {
                p.next = cycleStart;
                break;
            }
            p = p.next;
        }

        System.out.println(new DetectCycle().detectCycle(cycle1).val);
        System.out.println(new DetectCycle().detectCycle(cycle2).val);
    }
}
