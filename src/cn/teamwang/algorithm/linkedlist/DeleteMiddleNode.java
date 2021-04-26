package cn.teamwang.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 02.03. 删除中间节点
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class DeleteMiddleNode {
    public static void main(String[] args) {
        int[] nums = {4,5,1,9};
        ListNode head = ListNode.create(nums);
        head.print();
        System.out.println();
        deleteNode(head);
        head.print();
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
