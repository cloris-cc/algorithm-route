package cn.teamwang.algorithm.doublepointer;

/**
 * 141. 环形链表
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class HasCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(hasCycle1(node1));
        System.out.println(hasCycle2(node1));

//        ListNode n1 = new ListNode(1);
//
//        System.out.println(hasCycle(n1));

    }

    /**
     * 快慢指针
     *
     * 3 2 0 -4 2 0 -4 2 ...
     */
    public static boolean hasCycle1(ListNode head) {
        // maxLen为链表的最大长度
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next; // null.next?
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除自己(把指针指向自己)。
     * 1. 若是单向链表，最后会剩下尾部的null
     * 2. 若是环形链表，最后会出现head==head.next；
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next == head) {
            return true;
        }
        // 先存再改
        ListNode n = head.next;
        head.next = head;
        return hasCycle2(n);
    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
