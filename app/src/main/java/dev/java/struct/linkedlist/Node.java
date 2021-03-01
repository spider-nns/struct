package dev.java.struct.linkedlist;

public class Node<T> {
    T val;
    Node<T> next;
    Node<T> pre;

    public Node(T val) {
        this.val = val;
    }

    public Node() {
    }
}
