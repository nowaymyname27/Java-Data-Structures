package datastructures.LinkedLists;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(1);

        myLinkedList.append(2);
        myLinkedList.append(3);
        // myLinkedList.prepend(0);

        myLinkedList.printList();

        System.out.println(myLinkedList.findMiddleNode().value);

    }
}
