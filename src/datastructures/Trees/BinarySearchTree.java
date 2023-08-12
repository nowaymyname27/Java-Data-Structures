package datastructures.Trees;

public class BinarySearchTree {

    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public BinarySearchTree(int value) {
        Node newNode = new Node(value);
        root = newNode;
    }
}