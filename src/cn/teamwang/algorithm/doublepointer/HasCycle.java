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

        System.out.println(hasCycle(node1));

//        ListNode n1 = new ListNode(1);
//
//        System.out.println(hasCycle(n1));

    }

    /**
     * 3 2 0 -4 2 0 -4 2 ...
     */
    public static boolean hasCycle(ListNode head) {
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


    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
