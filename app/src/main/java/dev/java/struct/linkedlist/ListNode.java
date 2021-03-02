package dev.java.struct.linkedlist;

public class ListNode<T> {
    T val;
    ListNode<T> next;
    ListNode<T> pre;

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode() {
    }
}
