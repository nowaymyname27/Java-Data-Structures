package datastructures.LinkedLists;

public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList(0);
        myList.append(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);

        myList.reverseBetween(1, 4);
        // System.out.println(myList.hasLoop());
        myList.printList();
    }
}
