package cn.teamwang.algorithm.linkedlist;

import cn.teamwang.algorithm.linkedlist.Reverse.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 02.02
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class KthToLast {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = Reverse.create(nums);

        System.out.println(test2(head, 2));

    }

    /**
     * 改为顺序
     */
    public static int test1(ListNode head, int k) {
        if (head == null) {
            return 0;
        }

        int len = 0;
        ListNode node = head;
        while (head != null) { // 1-->2-->3-->4-->5 len:5 k:2
            len++;
            head = head.next;
        }
        for (int i = 0; i < len - k; i++) {
            node = node.next;
        }
        return node.val;
    }

    /**
     * list/数组
     */
    public static int test2(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        while (head != null) { // 1-->2-->3-->4-->5 len:5 k:2 index:3
            list.add(head.val);
            head = head.next;
        }
        return list.get(list.size() - k);
    }
}
