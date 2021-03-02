package dev.java.struct.linkedlist;

/**
 * @author spider
 * @date 2021/3/1
 */
public class LinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        loopLinkedList(3, 2);
//        printLinkedList(reverseLinkedList(head), false);
//        recursion(head);
//        loopLinkedList(3, 2);
        palindromeString();
    }
    // 链表通过指针将一组零散的内存块串联起来使用,针对CPU缓存不友好,没办法预读
    // 相对于数组内存消耗翻倍，频繁的插入、删除操作，会导致频繁的内存申请和释放，容易造成内存碎片,可能会导致频繁的GC
    // 结构 单链表、双向链表、循环链表

    // 单链表 节点(内存块) 存储数据和后继节点
    // 头节点(基地址) 尾节点 -> null
    static void singleLinkedList() {

    }

    //循环链表 约瑟夫环
    static void loopLinkedList(Integer sum, Integer out) {
        ListNode<Integer> h = new ListNode<>(1);
        initSingleLinkedListWithCapacity(h, sum, true);
        while (h != h.next) {
            for (int i = 1; i < out; i++) {
                h = h.next;
            }
            h.next = h.next.next;
        }
        System.out.println("alive is :" + h.val);

    }

    static void singleLoop(Integer sum, Integer count) {
        ListNode head = new ListNode(1);
        initSingleLinkedListWithCapacity(head, sum, true);
        if (count == 1) {
            System.out.println(sum);
            return;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur.next != cur) {
            for (int i = 1; i < count; i++) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = cur.next;
            cur.next = null;
            cur = pre.next;
            printLinkedList(cur, true);
        }
    }

    //双向链表 前驱指针 后继指针


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


    //reverse use double ListNode
    static ListNode reverseLinkedList(ListNode head) {
        ListNode left = null;
        while (head != null) {
            ListNode right = head.next;
            head.next = left;
            left = head;
            head = right;
        }
        return left;
    }


    //Palindrome string
    static Boolean palindromeString() {
        ListNode head = new ListNode(1);
        initSingleLinkedListWithCapacity(head, 6, false, true);
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null || fast.next != null) {
            fast = fast.next.next;
            ListNode cur = slow.next;
            pre = slow;
            slow = cur;
        }
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }

        return true;
    }


    //传入前驱变后继
    static void reverseLinkedListByRecursion(ListNode head, ListNode pre, ListNode[] arr) {
        ListNode cur = pre == null ? head : pre.next;
        if (cur.next != null) {
            reverseLinkedListByRecursion(head, cur, arr);
        } else {
            arr[0] = cur;
        }
        cur.next = pre;
    }

    static void recursion(ListNode head) {
        ListNode[] arr;
        arr = new ListNode[]{initSingleLinkedListWithCapacity(head, 5, false)};
        reverseLinkedListByRecursion(head, null, arr);
        printLinkedList(arr[0], false);
    }


}
