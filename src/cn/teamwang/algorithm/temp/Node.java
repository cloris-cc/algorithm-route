package cn.teamwang.algorithm.temp;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Node {
    private final int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void printLinkedList(Node head) {
        while (null != head) {
            System.out.print(head.value + " ");
            head = head.getNext();
        }
        System.out.println();
    }
}
