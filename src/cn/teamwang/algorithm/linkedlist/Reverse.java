package cn.teamwang.algorithm.linkedlist;

/**
 * 206
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Reverse {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.print();

        //
        int[] nums = {1, 2, 3, 4};
        System.out.println();
        create(nums).print();

        System.out.println();
        reverse1(head).print();
        System.out.println();
        reverse3(head).print();
        //
    }

    /**
     * 非递归
     */
    public static ListNode create(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode t = head;
        for (int i = 1; i < nums.length; i++) {
            t.next = new ListNode(nums[i]);
            t = t.next;
        }
        return head;
    }

    /**
     * 数组
     */
    public static ListNode reverse1(ListNode head) {
        int len = 1;
        ListNode t = head; //1 2 3 4

        while (t.next != null) {
            len++;
            t = t.next;
        }

        t = head;
        int[] nums = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            nums[i] = t.val;
            t = t.next;
        }
        return create(nums);
    }

    /**
     * 迭代
     * 和递归的区别：
     */
    public static ListNode reverse2(ListNode head) {
        return null;
    }

    /**
     * 递归
     */
    public static ListNode reverse3(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // 规模-1
        // 1-->2-->3-->4
        ListNode node = reverse3(head.next);
        // 2的指针指向1
        head.next.next = head;
        // 1的指针指向null
        head.next = null;
        return node;

    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        /**
         * 递归
         */
        public void add(int val) {
            ListNode node = new ListNode(val);
            if (this.next == null) {
                this.next = node;
            } else {
                this.next.add(val);
            }
        }

        public void print() {
            System.out.print(this.val);
            if (this.next != null) {
                System.out.print("-->");
                this.next.print();
            }
        }
    }

}
