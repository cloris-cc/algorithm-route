package cn.teamwang.algorithm.linkedlist;

/**
 * 剑指 Offer 18
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class DeleteNode {
    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 9};
        ListNode head = ListNode.create(nums);

        deleteNode(head, 5).print();
    }

    public static ListNode deleteNode(ListNode head, int val) {
        ListNode t = head;

        if (head.val == val) {
            t = head.next;
        }
        while (head.next != null) {
            // head:4head-->5-->1-->9 val:5
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return t;
    }
}
