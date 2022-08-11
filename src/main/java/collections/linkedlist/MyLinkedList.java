package collections.linkedlist;

import java.util.Arrays;

/**
 * @author Sergey Klunniy
 * мой линкед лист будет односвязным и не параметризованым
 */
public class MyLinkedList {
    private Node head;
    private int size;

    public void add(int value) {
        if (head == null) {
            //если первое добавление в список
            this.head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.next;
            }
            temp.setNext(new Node(value));
            // [1] -> [2] -> [3] -> [4]
        }
        size++;
    }

    @Override
    public String toString() {
        int[] result = new int[size];
        int idx = 0;
        Node temp = head;
//        while (temp.getNext() !=null) {
        while (temp != null) {
            result[idx++] = temp.getValue();
            temp = temp.getNext();
        }

        //изобрази это в виде примера
        return Arrays.toString(result);
    }

    public int get(int index) {
        int currentIndex = 0;
        Node temp = head;

        while (temp != null) {
            if (currentIndex == index) {
                return temp.getValue();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        // [1] -> [2] -> [3]
        throw new IllegalArgumentException();
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.getNext();
            size--;
            return;
        }

        int currentIndex = 0;  //это текущий индекс нашего указателяу
        Node temp = head;

        while (temp != null) {
            if (currentIndex == index - 1) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
