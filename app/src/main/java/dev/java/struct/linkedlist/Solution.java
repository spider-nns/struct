package dev.java.struct.linkedlist;

import static dev.java.struct.linkedlist.LinkedList.initSingleLinkedListWithCapacity;

class Solution<T> {
    public static void main(String[] args) {
        ListNode<Integer> ListNode = new ListNode<>(1);
        initSingleLinkedListWithCapacity(ListNode, 5, false);
        System.out.println(kthToLast(ListNode, 4));
    }

    public static int kthToLast(ListNode head, int k) {
        ListNode ListNode = reverseListNode(head);
        for (int i = 1; i < k; i++) {
            ListNode = ListNode.next;
        }
        return (int) ListNode.val;
    }

    public static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ListNode = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return ListNode;
    }
}