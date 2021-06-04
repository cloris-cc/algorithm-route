package cn.teamwang.algorithm.daily.leetcode;

import cn.teamwang.algorithm.linkedlist.ListNode;

/**
 * 203. 移除链表元素
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class RemoveElements {
    public static void main(String[] args) {

    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode res = head;
        while (res != null && res.val == val) {
            res = res.next;
        }
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return res;
    }
}
