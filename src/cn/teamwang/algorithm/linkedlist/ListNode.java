package cn.teamwang.algorithm.linkedlist;


/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public void print() {
        System.out.print(this.val);
        if (this.next != null) {
            System.out.print("-->");
            this.next.print();
        }
    }

    public static ListNode create(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode t = head;

        for (int i = 1; i < nums.length; i++) {
            head.next = new ListNode(nums[i]);
            head = head.next;
        }

        return t;
    }
}
