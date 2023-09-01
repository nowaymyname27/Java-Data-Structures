package datastructures.LinkedLists;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a singly linked list data structure.
 */
public class LinkedList {

    // Reference to the first node in the list.
    private Node head;

    // Reference to the last node in the list.
    private Node tail;

    // Total number of nodes in the list.
    private int length;

    /**
     * Represents a node in the LinkedList.
     */
    class Node {
        // Value stored in the node.
        int value;

        // Reference to the next node.
        Node next;

        /**
         * Constructor to initialize the node with a value.
         *
         * @param value The value to be stored in the node.
         */
        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        Node temp = head;
        Node pre = head;
        if (head == null)
            return null;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        Node temp = head;
        if (length == 0)
            return null;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;
        Node temp = head;
        if (index == 0)
            return temp;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;

    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == (length - 1)) {
            return removeLast();
        }
        Node pre = get(index - 1);
        Node temp = pre.next;
        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;

    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node pre = null;
        Node after = temp.next;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = pre;
            pre = temp;
            temp = after;
        }
    }

    public Node findMiddleNode() {
        Node turtle = head;
        Node hare = head;
        while (hare != tail) {
            hare = hare.next;
            turtle = turtle.next;
            if (hare.next != null) {
                hare = hare.next;
            }
        }
        return turtle;
    }

    public boolean hasLoop() {
        Node turtle = head;
        Node hare = head;
        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (hare == turtle) {
                return true;
            }
        }
        return false;
    }

    public Node findKthFromEnd(int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        int length = 1;
        Node temp = head;
        while (temp != tail) {
            temp = temp.next;
            length++;
        }
        if (k > length) {
            return null;
        }
        temp = head;
        int loop = length - k;
        for (int i = 0; i < loop; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void reverseBetween(int m, int n) {
        if (head == null) {
            return;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        for (int i = 0; i < m; i++) {
            prev = prev.next;
        }
        Node current = prev.next;
        int dist = n - m;
        Node temp = current.next;
        for (int i = 0; i < dist; i++) {
            temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        head = dummy.next;

    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void partitionList(int x) {
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node temp1 = dummy1;
        Node temp2 = dummy2;
        Node temp = head;
        while (temp != null) {
            if (temp.value < x) {
                temp1.next = temp;
                temp1 = temp1.next;
            } else {
                temp2.next = temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp1.next = dummy2.next;
        temp2.next = null;
        head = dummy1.next;
    }

    public void removeDuplicates() {
        Set<Integer> values = new HashSet<>();
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (values.contains(current.value)) {
                previous.next = current.next;
                length -= 1;
            } else {
                values.add(current.value);
                previous = current;
            }
            current = current.next;
        }
    }
}
