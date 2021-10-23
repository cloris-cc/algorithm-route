package cn.teamwang.algorithm.doublepointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class DetectCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(detectCycle(node1).val);
        System.out.println(detectCycle1(node1).val);

        ListNode n1 = new ListNode(1);
        System.out.println(detectCycle(n1));
        System.out.println(detectCycle1(n1));
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode res = null;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 有环
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                res = fast;
                break;
            }
        }
        return res;
    }

    public static ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();

        while (head.next != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
