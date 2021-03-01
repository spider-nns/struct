package dev.java.struct.linkedlist;

/**
 * @author spider
 * @date 2021/3/1
 */
public class LinkedLIst {
    public static void main(String[] args) {
        Node head = new Node(1);
//        loopLinkedList(3, 2);
//        printLinkedList(reverseLinkedList(head), false);
//        recursion
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
        Node<Integer> h = new Node<>(1);
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
        Node head = new Node(1);
        initSingleLinkedListWithCapacity(head, sum, true);
        if (count == 1) {
            System.out.println(sum);
            return;
        }
        Node pre = null;
        Node cur = head;
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


    static void printLinkedList(Node head, boolean loop) {
        Node h = head;
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

    static <T> Node initSingleLinkedListWithCapacity(Node<T> head, int capacity, boolean loop) {
        Node tem = head;
        for (int i = 0; i < capacity - 1; i++) {
            Node node = new Node(i + 2);
            tem.next = node;
            tem = node;
        }
        if (loop) {
            tem.next = head;
        }
        System.out.println("init a linkedList head is " + head.val + " ,capacity is " + capacity);
        printLinkedList(head, loop);
        return head;
    }

    static <T> Node initSingleLinkedListWithCapacity(Node<T> head, int capacity, boolean loop, Boolean fill) {
        Node tem = head;
        for (int i = 0; i < capacity - 1; i++) {
            Node node = null;
            if (fill) {
                node = new Node(capacity);
            }
            tem.next = node;
            tem = node;
        }
        if (loop) {
            tem.next = head;
        }
        System.out.println("init a linkedList head is " + head.val + " ,capacity is " + capacity);
        printLinkedList(head, loop);
        return head;
    }


    //reverse use double node
    static Node reverseLinkedList(Node head) {
        Node left = null;
        while (head != null) {
            Node right = head.next;
            head.next = left;
            left = head;
            head = right;
        }
        return left;
    }


    //Palindrome string
    static Boolean palindromeString() {
        Node head = new Node(1);
        initSingleLinkedListWithCapacity(head, 6, false, true);
        Node pre = null;
        Node slow = head;
        Node fast = head;
        while (fast != null || fast.next != null) {
            fast = fast.next.next;
            Node cur = slow.next;
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
    static void reverseLinkedListByRecursion(Node head, Node pre, Node[] arr) {
        Node cur = pre == null ? head : pre.next;
        if (cur.next != null) {
            reverseLinkedListByRecursion(head, cur, arr);
        } else {
            arr[0] = cur;
        }
        cur.next = pre;
    }

    static void recursion(Node head) {
        Node[] arr;
        arr = new Node[]{initSingleLinkedListWithCapacity(head, 5, false)};
        reverseLinkedListByRecursion(head, null, arr);
        printLinkedList(arr[0], false);
    }


}
