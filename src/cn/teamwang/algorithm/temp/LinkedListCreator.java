package cn.teamwang.algorithm.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class LinkedListCreator {

    public static void main(String[] args) {
        Node.printLinkedList(createLinkedList(Arrays.asList(1, 2, 3, 4, 5)));
        Node.printLinkedList(createLinkedList(Arrays.asList(1)));
        Node.printLinkedList(createLinkedList(new ArrayList<>()));
    }

    public static Node createLinkedList(List<Integer> data) {
        if (data.isEmpty()) {
            return null;
        }
        Node head = new Node(data.get(0));
        Node next = createLinkedList(data.subList(1, data.size()));
        head.setNext(next);
        return head;
    }

}
