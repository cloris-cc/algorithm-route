package cn.teamwang.algorithm.linkedlist;

import cn.teamwang.algorithm.linkedlist.Reverse.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 02.01
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class RemoveDuplicateNodes {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 2, 1};
        ListNode head = Reverse.create(nums);
        head.print();

        test2(head).print();
    }

    /**
     * 方法一：转换为数组，再转为链表
     */
    public static ListNode test1(ListNode head) {
        return null;
    }

    /**
     * todo 方法二：set去重
     */
    public static ListNode test2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        list.add(head.val);

        while (head.next != null) {
            if (list.contains(head.next.val)) {
                // 1-->2-->3head-->3-->....
                // 如果已有
                head.next = head.next.next;
//                head.next.next = null;
            } else {
                list.add(head.next.val);
                head = head.next;
            }
        }

//        System.out.println(list);
        return node;
    }
}
