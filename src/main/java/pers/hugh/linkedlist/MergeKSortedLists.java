package pers.hugh.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author dingxiuzheng
 */
public class MergeKSortedLists {

    //23. Merge k Sorted Lists
    //https://leetcode.com/problems/merge-k-sorted-lists/
    //时间复杂度O(kN)

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        //可以更换为优先级队列,整个算法时间复杂度由O(Nk)变为O(Nlogk)
        ListNode[] headList = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            headList[i] = lists[i];
        }

        while (isNotEmpty(headList)) {
            int minHeadIndex = 0;
            for (int i = 0; i < headList.length; i++) {
                ListNode head = headList[i];
                if (head == null) {
                    continue;
                }
                if (headList[minHeadIndex] == null) {
                    minHeadIndex = i;
                }
                if (headList[minHeadIndex].val > head.val) {
                    minHeadIndex = i;
                }
            }
            p.next = headList[minHeadIndex];
            p = p.next;
            headList[minHeadIndex] = headList[minHeadIndex].next;
        }
        return dummy.next;
    }

    public boolean isNotEmpty(ListNode[] lists) {
        for (ListNode node : lists) {
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        Queue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) {
            if (head != null) {
                priorityQueue.add(head);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode min = priorityQueue.poll();
            if (min.next != null) {
                priorityQueue.add(min.next);
            }
            p.next = min;
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] list = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };
        System.out.println(new MergeKSortedLists().mergeKLists(list));
        list = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };
        System.out.println(new MergeKSortedLists().mergeKLists2(list));
    }
}
