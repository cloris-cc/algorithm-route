package cn.teamwang.algorithm.dac;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public void print() {
        System.out.print(this.val);
        if (this.next !=null) {
            System.out.print("-->");
            this.next.print();
        }
    }
}
