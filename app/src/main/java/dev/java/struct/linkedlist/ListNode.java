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
    static void printLinkedList(ListNode head, boolean loop) {
        ListNode h = head;
        System.out.print("[ " + head.val + " -> ");
        if (loop) {
            while (h.next != head) {
                h = h.next;
                System.out.print(h.val + " -> ");
            }
        } else {
            while (h.next != null) {
                h = h.next;
                System.out.print(h.val + " -> ");
            }
        }
        System.out.println("]");
    }

    public static <T> ListNode initSingleLinkedListWithCapacity(ListNode<T> head, int capacity, boolean loop) {
        ListNode tem = head;
        for (int i = 0; i < capacity - 1; i++) {
            ListNode ListNode = new ListNode(i + 2);
            tem.next = ListNode;
            tem = ListNode;
        }
        if (loop) {
            tem.next = head;
        }
        System.out.println("init a linkedList head is " + head.val + " ,capacity is " + capacity);
        printLinkedList(head, loop);
        return head;
    }

    static <T> ListNode initSingleLinkedListWithCapacity(ListNode<T> head, int capacity, boolean loop, Boolean fill) {
        ListNode tem = head;
        for (int i = 0; i < capacity - 1; i++) {
            ListNode ListNode = null;
            if (fill) {
                ListNode = new ListNode(capacity);
            }
            tem.next = ListNode;
            tem = ListNode;
        }
        if (loop) {
            tem.next = head;
        }
        System.out.println("init a linkedList head is " + head.val + " ,capacity is " + capacity);
        printLinkedList(head, loop);
        return head;
    }
}
