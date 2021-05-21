package cn.teamwang.algorithm.daily.nowcoder;

import cn.teamwang.algorithm.linkedlist.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 如果该链表长度小于k，请返回空。
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class FindKthToTail {
    public static void main(String[] args) {
        ListNode test1 = new ListNode(0);
        FindKthToTail(test1, 2).print();
    }

    public static ListNode FindKthToTail(ListNode pHead, int k) {
        ListNode fast = pHead;
        ListNode slow = pHead;

        while (k != 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
