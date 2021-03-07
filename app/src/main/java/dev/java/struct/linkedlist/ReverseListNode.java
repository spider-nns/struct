package dev.java.struct.linkedlist;

import org.checkerframework.checker.units.qual.K;

import java.security.acl.Group;

/**
 * @author spider
 * @date 2021/3/7
 */
public class ReverseListNode {
    static ListNode next = null;

    public static void main(String[] args) {
//        doubleReverse();
//        recursionReverseListNode();
//        reversePreNListNode(3);
//        reverseListNodeBetween(2, 4);
        reverseListNodeByGroup(2);
    }


    //反转单链表-双指针
    static void doubleReverse() {
        ListNode<Integer> head = new ListNode<>(1);
        ListNode.initSingleLinkedListWithCapacity(head, 5, false);
        ListNode pre = null;
        ListNode temHead;
        while (head != null) {
            temHead = head.next;
            head.next = pre;
            pre = head;
            head = temHead;
        }
        ListNode.printLinkedList(pre, false);
    }

    static void recursionReverseListNode() {
        ListNode head = new ListNode(1);
        ListNode.initSingleLinkedListWithCapacity(head, 5, false);
        ListNode newHead = recursion(head);
        ListNode.printLinkedList(newHead, false);
    }

    //反转单链表-递归
    static ListNode recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //反转单链表-前N个节点
    static void reversePreNListNode(int preCount) {
        ListNode head = new ListNode(1);
        ListNode.initSingleLinkedListWithCapacity(head, 5, false);
        ListNode newHead = reversePreN(head, 3);
        ListNode.printLinkedList(newHead, false);

    }

    static ListNode reversePreN(ListNode head, int preN) {
        if (preN == 1) {
            next = head.next;
            return head;
        }
        ListNode last = reversePreN(head.next, preN - 1);
        head.next.next = head;
        head.next = next;
        return last;
    }

    //反转单链表-区间
    static void reverseListNodeBetween(int from, int to) {
        ListNode head = new ListNode(1);
        ListNode.initSingleLinkedListWithCapacity(head, 6, false);
        ListNode newHead = reverseBetween(head, from, to);
        ListNode.printLinkedList(newHead, false);
    }

    static ListNode reverseBetween(ListNode head, int from, int to) {
        if (from == 1) {
            return reversePreN(head, to);
        }
        head.next = reverseBetween(head.next, from - 1, to - 1);
        return head;
    }

    static void reverseListNodeByGroup(int group) {
        ListNode<Integer> head = new ListNode<>(1);
        ListNode.initSingleLinkedListWithCapacity(head, 15, false);
        ListNode newHead = reverseByGroup(head, group);
        ListNode.printLinkedList(newHead, false);
    }

    static ListNode reverseByGroup(ListNode head, int group) {
        if (head == null) return null;
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < group; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseByGroup(b, group);
        return newHead;
    }

    static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, next;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
