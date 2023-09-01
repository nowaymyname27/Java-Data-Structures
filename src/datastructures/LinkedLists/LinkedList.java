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

    /**
     * Constructs a new LinkedList with a single node containing the provided value.
     *
     * @param value The value for the initial node of the LinkedList.
     */
    public LinkedList(int value) {
        // Create a new node with the provided value
        Node newNode = new Node(value);

        // Set the head and tail to point to the new node
        head = newNode;
        tail = newNode;

        // Set the initial length of the list to 1
        length = 1;
    }

    /**
     * Prints the values of all the nodes in the LinkedList to the console.
     */
    public void printList() {
        // Start from the head of the list
        Node temp = head;

        // Traverse the list
        while (temp != null) {
            // Print the current node's value
            System.out.println(temp.value);

            // Move to the next node
            temp = temp.next;
        }
    }

    /**
     * Prints the value of the head node to the console.
     * If the list is empty, it prints "Head: null".
     */
    public void getHead() {
        // Check if the list is empty
        if (head == null) {
            System.out.println("Head: null");
        } else {
            // Print the value of the head node
            System.out.println("Head: " + head.value);
        }
    }

    /**
     * Prints the value of the tail node to the console.
     * If the list is empty, it prints "Tail: null".
     */
    public void getTail() {
        // Check if the list is empty
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            // Print the value of the tail node
            System.out.println("Tail: " + tail.value);
        }
    }

    /**
     * Prints the current length of the LinkedList to the console.
     */
    public void getLength() {
        System.out.println("Length: " + length);
    }

    /**
     * Appends a new node with the given value to the end of the LinkedList.
     *
     * @param value The value for the new node to be appended.
     */
    public void append(int value) {
        // Create a new node with the given value
        Node newNode = new Node(value);

        // Check if the list is empty
        if (length == 0) {
            // If the list is empty, set the head and tail to point to the new node
            head = newNode;
            tail = newNode;
        } else {
            // Otherwise, link the new node after the current tail and update the tail
            tail.next = newNode;
            tail = newNode;
        }

        // Increment the length of the list
        length++;
    }

    /**
     * Removes the last node from the LinkedList and returns it.
     * If the list is empty, it returns null.
     *
     * @return The last node that was removed, or null if the list was empty.
     */
    public Node removeLast() {
        // Start with the head of the list
        Node temp = head;

        // Create a pointer for the previous node, also start from head
        Node pre = head;

        // If the list is empty, return null
        if (head == null) {
            return null;
        }

        // Traverse until the end of the list while maintaining a pointer to the
        // previous node
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        // Update the tail to be the previous node
        tail = pre;
        // Disconnect the last node
        tail.next = null;

        // Decrement the length of the list
        length--;

        // If the list becomes empty after the removal, set both head and tail to null
        if (length == 0) {
            head = null;
            tail = null;
        }

        // Return the node that was removed
        return temp;
    }

    /**
     * Adds a new node with the given value to the beginning of the LinkedList.
     *
     * @param value The value for the new node to be prepended.
     */
    public void prepend(int value) {
        // Create a new node with the given value
        Node newNode = new Node(value);

        // Check if the list is empty
        if (length == 0) {
            // If the list is empty, set the head and tail to point to the new node
            head = newNode;
            tail = newNode;
        } else {
            // Otherwise, link the new node before the current head and update the head
            newNode.next = head;
            head = newNode;
        }

        // Increment the length of the list
        length++;
    }

    /**
     * Removes the first node from the LinkedList and returns it.
     * If the list is empty, it returns null.
     *
     * @return The first node that was removed, or null if the list was empty.
     */
    public Node removeFirst() {
        // Store a reference to the current head of the list
        Node temp = head;

        // If the list is empty, return null
        if (length == 0) {
            return null;
        }

        // Update the head to point to the next node
        head = head.next;

        // Disconnect the removed node from the list
        temp.next = null;

        // Decrement the length of the list
        length--;

        // If the list becomes empty after the removal, set the tail to null
        if (length == 0) {
            tail = null;
        }

        // Return the node that was removed
        return temp;
    }

    /**
     * Retrieves a node at the specified index in the LinkedList.
     *
     * @param index The index of the node to retrieve.
     * @return The node at the specified index or null if the index is out of
     *         bounds.
     */
    public Node get(int index) {
        // Check if the index is out of bounds and return null if it is
        if (index < 0 || index >= length) {
            return null;
        }

        // Start from the head of the list
        Node temp = head;

        // If the requested index is 0, return the head
        if (index == 0) {
            return temp;
        }

        // Traverse the list to the specified index
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        // Return the node at the specified index
        return temp;
    }

    /**
     * Sets the value of a node at the specified index in the LinkedList.
     *
     * @param index The index of the node whose value is to be set.
     * @param value The new value to set for the node.
     * @return true if the value was set successfully, false otherwise.
     */
    public boolean set(int index, int value) {
        // Get the node at the specified index using the previously defined get method
        Node temp = get(index);

        // If the node exists (i.e., the index is valid)
        if (temp != null) {
            // Update the value of the node
            temp.value = value;
            return true; // Value was set successfully
        }

        // If the index is invalid or the node doesn't exist
        return false;
    }

    /**
     * Inserts a new node with the specified value at the given index in the
     * LinkedList.
     * 
     * @param index The index where the new node is to be inserted.
     * @param value The value for the new node to be inserted.
     * @return true if the node was inserted successfully, false otherwise.
     */
    public boolean insert(int index, int value) {
        // Check if the index is out of bounds
        if (index < 0 || index > length) {
            return false; // Index is invalid
        }

        // If index is 0, simply prepend the new node to the beginning of the list
        if (index == 0) {
            prepend(value);
            return true;
        }

        // If index is equal to the length of the list, append the new node to the end
        // of the list
        if (index == length) {
            append(value);
            return true;
        }

        // If index is in the middle, create a new node with the given value
        Node newNode = new Node(value);
        // Get the node just before the specified index
        Node temp = get(index - 1);
        // Point the new node's 'next' to the current node at the specified index
        newNode.next = temp.next;
        // Update the 'next' pointer of the preceding node to the new node
        temp.next = newNode;

        // Increment the length of the list since a new node has been added
        length++;

        return true; // Node was inserted successfully
    }

    /**
     * Removes the node at the specified index from the LinkedList.
     *
     * @param index The index of the node to be removed.
     * @return The removed node if the operation was successful, null otherwise.
     */
    public Node remove(int index) {
        // Check if the index is out of bounds
        if (index < 0 || index >= length) {
            return null; // Invalid index, so return null
        }

        // If the index is 0, remove and return the first node using the removeFirst
        // method
        if (index == 0) {
            return removeFirst();
        }

        // If the index points to the last node, remove and return the last node using
        // the removeLast method
        if (index == (length - 1)) {
            return removeLast();
        }

        // If index points to a middle node in the list
        // Get the node just before the node to be removed
        Node pre = get(index - 1);
        // Get the node to be removed
        Node temp = pre.next;
        // Update the 'next' pointer of the preceding node to skip over the node to be
        // removed
        pre.next = temp.next;
        // Disconnect the node to be removed from the list
        temp.next = null;

        // Decrement the length since a node has been removed
        length--;

        return temp; // Return the removed node
    }

    /**
     * Reverses the LinkedList in-place.
     */
    public void reverse() {
        // Create a temporary variable to store the current head
        Node temp = head;

        // Swap head and tail references
        head = tail;
        tail = temp;

        // Initialize pointers for the previous and next nodes
        Node pre = null;
        Node after = temp.next;

        // Iterate through the LinkedList
        for (int i = 0; i < length; i++) {
            // Update the after pointer to the next node
            after = temp.next;

            // Change the next pointer of the current node to point to the previous node
            temp.next = pre;

            // Move the previous node pointer to the current node
            pre = temp;

            // Move to the next node in the original sequence
            temp = after;
        }
    }

    /**
     * Finds the middle node of the LinkedList using the turtle and hare approach.
     * 
     * @return The middle node of the LinkedList. If the list has an even number of
     *         nodes,
     *         it returns the second middle node.
     */
    public Node findMiddleNode() {
        // The turtle pointer moves one step at a time
        Node turtle = head;

        // The hare pointer moves two steps at a time
        Node hare = head;

        // Loop until the hare reaches the tail
        while (hare != tail) {
            // Move hare one step
            hare = hare.next;

            // Move turtle one step
            turtle = turtle.next;

            // If hare is not yet at the tail, move it a second step
            if (hare.next != null) {
                hare = hare.next;
            }
        }

        // When hare reaches the tail, turtle will be at the middle
        return turtle;
    }

    /**
     * Determines if the LinkedList contains a loop using the turtle and hare
     * approach.
     * 
     * @return true if the LinkedList has a loop, otherwise false.
     */
    public boolean hasLoop() {
        // The turtle pointer moves one step at a time
        Node turtle = head;

        // The hare pointer moves two steps at a time
        Node hare = head;

        // Loop until hare reaches the end or finds a loop
        while (hare != null && hare.next != null) {
            // Move turtle one step
            turtle = turtle.next;

            // Move hare two steps
            hare = hare.next.next;

            // If hare and turtle pointers meet, then there's a loop
            if (hare == turtle) {
                return true;
            }
        }

        // If hare reaches the end of the list without meeting turtle, then no loop
        // exists
        return false;
    }

    /**
     * Finds the kth node from the end of the LinkedList.
     * 
     * @param k The position from the end to retrieve the node.
     * @return The kth node from the end, or null if k is out of range or the list
     *         is empty.
     */
    public Node findKthFromEnd(int k) {
        // Validate k and check if list is empty
        if (k <= 0 || head == null) {
            return null;
        }

        // Initialize length of the LinkedList to 1
        int length = 1;
        Node temp = head;

        // Traverse the list to calculate its length
        while (temp != tail) {
            temp = temp.next;
            length++;
        }

        // If k is greater than the length of the list, it's out of range
        if (k > length) {
            return null;
        }

        // Reset temp to the head of the list
        temp = head;

        // Calculate the number of nodes to skip from the start
        int loop = length - k;

        // Traverse the list to the (length - k)th node
        for (int i = 0; i < loop; i++) {
            temp = temp.next;
        }

        // Return the (length - k)th node which is the kth node from the end
        return temp;
    }

    /**
     * Reverses the sublist of the LinkedList from the mth node to the nth node.
     * 
     * @param m The start index of the sublist (1-based index).
     * @param n The end index of the sublist (1-based index).
     */
    public void reverseBetween(int m, int n) {
        // If the LinkedList is empty, nothing to do
        if (head == null) {
            return;
        }

        // Create a dummy node to help in edge cases where m is 1.
        Node dummy = new Node(0);
        dummy.next = head;

        // Move prev pointer m-1 positions ahead (to node just before the reversal
        // starts)
        Node prev = dummy;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }

        // Current points to the mth node, which will be the end of the reversed
        // sublist.
        Node current = prev.next;

        // Calculate the number of swaps required
        int dist = n - m;

        // temp is used to keep track of the current node that is being moved
        Node temp = current.next;

        // Loop through and rearrange the pointers to reverse the sublist
        for (int i = 0; i < dist; i++) {
            temp = current.next; // Move temp to the next node
            current.next = temp.next; // Current's next points to the node after temp
            temp.next = prev.next; // Move temp to the front of the sublist
            prev.next = temp; // Update prev's next to temp
        }

        // Update the head to point to the start of the modified LinkedList
        head = dummy.next;
    }

    /**
     * Empties the LinkedList, resetting the head, tail, and length.
     */
    public void makeEmpty() {
        // Set head and tail pointers to null
        head = null;
        tail = null;

        // Reset the length to 0
        length = 0;
    }

    /**
     * Rearranges the LinkedList such that all nodes with values less than x
     * come before nodes with values greater than or equal to x.
     * 
     * @param x The partition value.
     */
    public void partitionList(int x) {
        // Create two dummy nodes:
        // - dummy1 will be the start of the list with nodes having values less than x.
        // - dummy2 will be the start of the list with nodes having values greater than
        // or equal to x.
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        // Pointers to the current nodes in each partition list
        Node temp1 = dummy1;
        Node temp2 = dummy2;

        // Pointer to traverse the original list
        Node temp = head;

        // Traverse through the original list
        while (temp != null) {
            // If the node's value is less than x, add it to the list of nodes less than x
            if (temp.value < x) {
                temp1.next = temp;
                temp1 = temp1.next;
            }
            // Otherwise, add it to the list of nodes greater than or equal to x
            else {
                temp2.next = temp;
                temp2 = temp2.next;
            }

            // Move to the next node
            temp = temp.next;
        }

        // Merge the two lists: attach the list of nodes greater than or equal to x
        // at the end of the list of nodes less than x
        temp1.next = dummy2.next;

        // Ensure the new tail does not point to any other node
        temp2.next = null;

        // Update the head of the LinkedList to point to the new starting node
        head = dummy1.next;
    }

    /**
     * Removes duplicate nodes from an unsorted LinkedList.
     */
    public void removeDuplicates() {
        // Create a HashSet to store the unique values seen so far
        Set<Integer> values = new HashSet<>();

        // 'previous' keeps track of the node just before 'current'
        Node previous = null;

        // 'current' points to the node we are currently checking
        Node current = head;

        // Traverse through the LinkedList
        while (current != null) {
            // If the current node's value has been seen before (i.e., it's in the HashSet)
            if (values.contains(current.value)) {
                // Bypass the current node, essentially removing it
                previous.next = current.next;

                // Decrement the length of the LinkedList
                length -= 1;
            }
            // If the current node's value hasn't been seen before
            else {
                // Add the value to the HashSet
                values.add(current.value);

                // Update the 'previous' node to the current node
                previous = current;
            }

            // Move to the next node
            current = current.next;
        }
    }
}
