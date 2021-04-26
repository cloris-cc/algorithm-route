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

        test(head, 2).print();

    }

    public static ListNode test(ListNode head, int k) {
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
}
