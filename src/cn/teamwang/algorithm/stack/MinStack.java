package cn.teamwang.algorithm.stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 *
 * 可以用链表来实现栈(先进后出的特性)。
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MinStack {
    private ListNode head;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new ListNode(x, x, null);
        } else {
            // 3(head)->2->1
            head = new ListNode(x, Math.min(head.min, x), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int min() {
        return head.min;
    }


    private static class ListNode {
        int val;
        int min;
        ListNode next;

        public ListNode(int val, int min, ListNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
