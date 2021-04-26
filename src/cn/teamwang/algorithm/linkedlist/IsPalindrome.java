package cn.teamwang.algorithm.linkedlist;

import sun.tools.jstack.JStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 面试题 02.06
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class IsPalindrome {
    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        System.out.println(isPalindrome(ListNode.create(nums)));
    }

    /**
     * 对称 != stack
     */
    public static boolean isPalindrome(ListNode head) {
        // list 转数组？没必要
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) { // 1->2->2->1 size/2:2
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
