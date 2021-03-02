package dev.java.struct.linkedlist;

/**
 * @author spider
 * @date 2021/3/3
 */
public class Solution2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(1);
        LinkedList.initSingleLinkedListWithCapacity(head, 5, false);
        LinkedList.initSingleLinkedListWithCapacity(head1, 6, false);
        ListNode last;
        while (head1.next != null) {
            head1 = head1.next;
        }
        last = head1;
        LinkedList.printLinkedList(deleteNodeByVal(head, head.next), false);
        LinkedList.printLinkedList(deleteNodeByVal(head1, last), false);
    }

    static ListNode<Integer> deleteNodeByVal(ListNode<Integer> head, ListNode delNode) {
        ListNode result = head;
        if (delNode.next == null) {
            while (result.val != delNode.val) {
                result = result.next;
            }
            result.next = null;
            return result;
        } else {
            while (head.next != null) {
                if (head.val == delNode.val) {
                    head.val = head.next.val;
                    head.next = head.next.next;
                    return result;
                }
                head = head.next;
            }
            return null;
        }
    }
}
