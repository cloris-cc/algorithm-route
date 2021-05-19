package cn.teamwang.algorithm.dac;

/**
 * 21. 合并两个有序链表
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(-9);
        ListNode n2 = new ListNode(3);
        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(7);
        n1.next = n2;
        m1.next = m2;
        mergeTwoLists(n1, m1).print();
        System.out.println();
        mergeTwoLists_simplified(n1, m1).print();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode t = head;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    t.next = new ListNode(l1.val);
                    l1 = l1.next;
                    t = t.next;
                } else if (l1.val > l2.val) {
                    t.next = new ListNode(l2.val);
                    l2 = l2.next;
                    t = t.next;
                } else {
                    t.next = new ListNode(l1.val);
                    l1 = l1.next;
                    t = t.next;
                    t.next = new ListNode(l2.val);
                    l2 = l2.next;
                    t = t.next;
                }
            } else if (l1 == null) {
                t.next = new ListNode(l2.val);
                l2 = l2.next;
                t = t.next;
            } else {
                t.next = new ListNode(l1.val);
                l1 = l1.next;
                t = t.next;
            }
        }
        return head.next;
    }

    /**
     * 简化代码
     */
    public static ListNode mergeTwoLists_simplified(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode t = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                t.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                t.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            t = t.next;
        }
        t.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
