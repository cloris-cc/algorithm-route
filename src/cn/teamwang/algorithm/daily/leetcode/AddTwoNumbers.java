package cn.teamwang.algorithm.daily.leetcode;

import cn.teamwang.algorithm.linkedlist.ListNode;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode n11 = new ListNode(2);
        ListNode n12 = new ListNode(4);
        ListNode n13 = new ListNode(3);
        n11.next = n12;
        n12.next = n13;
        ListNode n21 = new ListNode(5);
        ListNode n22 = new ListNode(6);
        ListNode n23 = new ListNode(4);
        n21.next = n22;
        n22.next = n23;
        addTwoNumbers1(n11, n21).print();
    }

    /**
     * 一定要看题目的提示，再想想自己的方法可不可行。(题目提示：每个链表中的节点数在范围 [1, 100] 内)
     * <p>
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * <p>
     * 只能按位相加，不能直接两数相加
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // 转为字符串，再按位相加
        ListNode head;
        String s1 = "", s2 = "";

        while (l1 != null) {
            s1 += l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            s2 += l2.val;
            l2 = l2.next;
        }

        int[] bits = new int[Math.max(s1.length(), s2.length())];

        for (int i = 0; i < bits.length; i++) {
            // i有可能超过s1或s2
            int sum = 0;
            if (i >= s1.length()) {
                sum = s2.charAt(i) - '0';
            } else if (i >= s2.length()) {
                sum = s1.charAt(i) - '0';
            } else {
                sum = s1.charAt(i) - '0' + s2.charAt(i) - '0';
            }
            if (i + 1 < bits.length && sum >= 10) {
                bits[i + 1]++;
                sum -= 10;
            }
            // 如果t=9,且已经bits[i]=1
            if (i + 1 < bits.length && sum == 9 && bits[i] == 1) {
                bits[i] = 0;
                bits[i + 1]++;
            } else {
                bits[i] += sum;
            }
        }

        boolean flag = false;
        if (bits[bits.length - 1] >= 10) {
            bits[bits.length - 1] -= 10;
            flag = true;
        }

        head = new ListNode(bits[0]);
        ListNode t = head;

        for (int i = 1; i < bits.length; i++) {

            t.next = new ListNode(bits[i]);
            t = t.next;
        }
        if (flag) {
            t.next = new ListNode(1);
        }
        return head;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode t = head;
        int over = 0;

        while (l1 != null || l2 != null || over != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + over;
            over = sumVal / 10;

            t.next = new ListNode(sumVal % 10);
            t = t.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return head.next;
    }
}
