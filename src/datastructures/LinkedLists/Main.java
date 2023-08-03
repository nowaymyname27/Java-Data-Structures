package datastructures.LinkedLists;

public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList(2);
        myList.append(8);
        myList.append(1);
        myList.append(4);
        myList.append(3);
        myList.append(7);

        myList.partitionList(4);
        // System.out.println(myList.hasLoop());
        myList.printList();
    }
}
