package cn.teamwang.algorithm.linkedlist;

/**
 * todo 剑指 Offer 52. 两个链表的第一个公共节点
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        int[] numsA = {0,9,1,2,4};
        int[] numsB = {3,2,4};
        ListNode headA = ListNode.create(numsA);
        ListNode headB = ListNode.create(numsB);
        getIntersectionNode1(headA, headB).print();

    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {

            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    /**
     * 反转链表
     * ERROR: 题目原意不是节点的值相同，而是引用地址相同。
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode r1 = reverse(headA);
        ListNode r2 = reverse(headB);

        if (r1.val == r2.val) {
            ListNode res = new ListNode(r1.val);
            ListNode t = res;

            while(r1.next != null && r2.next != null) {
                if (r1.next.val == r2.next.val) {
                    t.next = new ListNode(r1.next.val);
                    t = t.next;
                }

                r1 = r1.next;
                r2 = r2.next;
            }
            return reverse(res);
        }else {
            return null;
        }

    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1-->2-->...
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


}
