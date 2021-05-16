package cn.teamwang.algorithm.linkedlist;

import cn.teamwang.algorithm.linkedlist.Reverse.ListNode;

/**
 * 剑指 Offer 22
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class GetKthFromEnd {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = Reverse.create(nums);

        getKthFromEnd1(head, 2).print();

    }

    public static ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode t = head;
        int count = 0;

        while (head != null) {
            count++;
            head = head.next;
        }

        // 1->2->3->4->5, 和 k = 2. count:5
        for (int i = 0; i < count - k; i++) {
            t = t.next;
        }

        return t;
    }

    /**
     * 双指针：让快指针先走 k 步，然后快慢指针开始同速前进。这样当快指针走到链表末尾 null 时，慢指针所在的位置就是倒数第 k 个链表节点
     */
    public static ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode slow, fast;
        slow = fast = head;
        while (k-- > 0)
            fast = fast.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
