package dev.java.struct.linkedlist;

class Solution1 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        LinkedList.initSingleLinkedListWithCapacity(head, 5, false);
        ListNode kthFromEnd = getKthFromEnd(head, 2);
        LinkedList.printLinkedList(kthFromEnd, false);
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {

        ListNode node = reverseNode(head);
        ListNode newHead = new ListNode();
        ListNode tem = newHead;
        for (int i = 0; i < k; i++) {
            newHead.next = new ListNode(node.val);
            node = node.next;
            newHead = newHead.next;
        }
        return reverseNode(tem);
    }

    public static ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            if (k == 0) {
                head = head.next;
            } else {
                k--;
            }
        }
        return head;
    }

    public static ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}