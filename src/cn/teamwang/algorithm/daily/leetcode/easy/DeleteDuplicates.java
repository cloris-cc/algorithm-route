package cn.teamwang.algorithm.daily.leetcode.easy;

import cn.teamwang.algorithm.linkedlist.ListNode;

import java.util.List;

/**
 * 83. 删除排序链表中的重复元素
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
//        int[] nums1 = {1,1,2};
//        int[] nums2 = {1,1,2,3,3};
//        ListNode node1 = ListNode.create(nums1);
//        ListNode node2 = ListNode.create(nums2);
//        deleteDuplicates(node1).print();
//        deleteDuplicates(node2).print();
        int[] nums3 = {1,1,1};
        ListNode node3 = ListNode.create(nums3);
        deleteDuplicates(node3).print();

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return res;
    }
}
