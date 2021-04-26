package cn.teamwang.algorithm.temp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class LinkedListReverser {
    public static void main(String[] args) {
        Node.printLinkedList(reverseLinkedList(LinkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5))));
        Node.printLinkedList(reverseLinkedList(LinkedListCreator.createLinkedList(Arrays.asList(1))));
        Node.printLinkedList(reverseLinkedList(LinkedListCreator.createLinkedList(new ArrayList<>())));
    }

    private static Node reverseLinkedList(Node head) {
        if (null == head || null == head.getNext()) {
            return head;
        }
        Node newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }
}
