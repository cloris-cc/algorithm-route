package cn.teamwang.algorithm.doublepointer;


/**
 * 876. 链表的中间结点
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MiddleNode {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println(middleNode2(n1).val);
    }

    /**
     * 普通解法
     */
    public static ListNode middleNode1(ListNode head) {
        int len = 0;
        // 保存头部引用
        ListNode temp = head;

        while (head != null) {
            len++;
            head = head.next;
        }
        head = temp;
        for (int i = 0; i < len / 2; i++) {
            head = head.next;
        }
        return head;
    }

    /**
     * 快慢指针
     */
    public static ListNode middleNode2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
