package cn.teamwang.algorithm.linkedlist;

/**
 * 剑指 Offer 06
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class ReversePrint {
    public static void main(String[] args) {

    }

    public int[] reversePrint(ListNode head) {
        // todo 递归反转链表

        // eg 1 2 3 ,cap = 3,
        ListNode temp = head;
        int capacity = 0;
        while (temp != null) {
            capacity++;
            temp = temp.next;
        }

        int[] nums = new int[capacity];
        for (int i = capacity - 1; i >= 0; i--) {
            nums[i] = head.val;
            head = head.next;
        }

        return nums;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
