package pers.hugh.linkedlist;

/**
 * @author dingxiuzheng
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int... vals) {
        this.val = vals[0];
        ListNode p = this;
        for (int i = 1; i < vals.length; i++) {
            p.next = new ListNode(vals[i]);
            p = p.next;
        }
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode l = this;
        //计算次数，防止出现环
        int i = 0;
        while (l != null && i <= 100) {
            sb.append(l.val);
            sb.append(",");
            l = l.next;
            i++;
        }
        if (i == 100) {
            sb.append("链表可能有环");
        }
        return sb.substring(0, sb.length() - 1);
    }
}