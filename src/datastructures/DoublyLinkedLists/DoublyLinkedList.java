package datastructures.DoublyLinkedLists;

public class DoublyLinkedList {

    // Head of the doubly linked list
    private Node head;

    // Tail of the doubly linked list
    private Node tail;

    // Length or size of the doubly linked list
    private int length;

    // Inner class representing a Node in the Doubly Linked List
    class Node {
        int value; // Value held by the node
        Node next; // Pointer to the next node in the list
        Node prev; // Pointer to the previous node in the list

        /**
         * Constructor for the Node class.
         *
         * @param value The value to be held by the node.
         */
        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Constructor for the DoublyLinkedList class.
     * Initializes the list with a single node with the given value.
     *
     * @param value The value of the first node in the list.
     */
    public DoublyLinkedList(int value) {
        // Create a new node with the given value
        Node newNode = new Node(value);
        head = newNode; // Set head to the new node
        tail = newNode; // Set tail to the new node
        length = 1; // Initialize length of the list as 1
    }

    /**
     * Prints the values of the nodes in the doubly linked list.
     * The values are printed from the head to the tail of the list.
     */
    public void printList() {
        // Start at the head of the list
        Node temp = head;

        // Traverse the list until we reach the end (where temp is null)
        while (temp != null) {
            // Print the value of the current node
            System.out.println(temp.value);

            // Move to the next node in the list
            temp = temp.next;
        }
    }

    /**
     * Prints the value of the head node of the doubly linked list.
     * If the list is empty (head is null), it prints "Head: null".
     */
    public void getHead() {
        // Check if the head is null (list is empty)
        if (head == null) {
            System.out.println("Head: null");
        } else {
            // Print the value of the head node
            System.out.println("Head: " + head.value);
        }
    }

    /**
     * Prints the value of the tail node of the doubly linked list.
     * If the list is empty (head is null), it prints "Tail: null".
     */
    public void getTail() {
        // Check if the head is null (list is empty)
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            // Print the value of the tail node
            System.out.println("Tail: " + tail.value);
        }
    }

    /**
     * Prints the current length of the doubly linked list.
     */
    public void getLength() {
        System.out.println("Length: " + length);
    }

    /**
     * Appends a new node with the given value to the end of the doubly linked list.
     *
     * @param value The value of the new node to be appended.
     */
    public void append(int value) {
        // Create a new node with the given value
        Node newNode = new Node(value);

        // Check if the list is empty
        if (length == 0) {
            head = newNode; // Set head to the new node
            tail = newNode; // Set tail to the new node
        } else {
            // Link the new node to the current tail
            tail.next = newNode;
            newNode.prev = tail;

            // Set the tail to the new node
            tail = newNode;
        }
        // Increment the length of the list
        length++;
    }

    /**
     * Removes the tail node (last node) from the doubly linked list.
     *
     * @return The removed node. If the list was empty, returns null.
     */
    public Node removeLast() {
        // Check if the list is empty
        if (length == 0) {
            return null;
        }

        // Save the current tail node in a temporary variable
        Node temp = tail;

        // If there's only one node in the list
        if (length == 1) {
            tail = null; // Set the tail to null
            head = null; // Set the head to null as well
        } else {
            // Point the tail to the previous node
            tail = tail.prev;

            // Break the link between the last and second last nodes
            tail.next = null;

            // Nullify the previous pointer of the removed node
            temp.prev = null;
        }

        // Decrement the length of the list
        length--;

        // Return the removed node
        return temp;
    }

    /**
     * Adds a new node with the given value to the start of the doubly linked list.
     *
     * @param value The value of the new node to be prepended.
     */
    public void prepend(int value) {
        // Create a new node with the given value
        Node newNode = new Node(value);

        // Check if the list is empty
        if (length == 0) {
            head = newNode; // Set head to the new node
            tail = newNode; // Set tail to the new node
        } else {
            // Link the new node to the current head
            newNode.next = head;
            head.prev = newNode;

            // Set the head to the new node
            head = newNode;
        }

        // Increment the length of the list
        length++;
    }

    /**
     * Removes the head node (first node) from the doubly linked list.
     *
     * @return The removed node. If the list was empty, returns null.
     */
    public Node removeFirst() {
        // Check if the list is empty
        if (length == 0) {
            return null;
        }

        // Save the current head node in a temporary variable
        Node temp = head;

        // If there's only one node in the list
        if (length == 1) {
            head = null; // Set the head to null
            tail = null; // Set the tail to null as well
        } else {
            // Point the head to the next node
            head = head.next;

            // Break the link between the first and second nodes
            head.prev = null;

            // Nullify the next pointer of the removed node
            temp.next = null;
        }

        // Decrement the length of the list
        length--;

        // Return the removed node
        return temp;
    }

    /**
     * Retrieves the node at a specified index in the doubly linked list.
     *
     * @param index The index of the desired node, starting from 0.
     * @return The node at the specified index or null if the index is out of
     *         bounds.
     */
    public Node get(int index) {
        // Check for index out of bounds
        if (index < 0 || index >= length) { // Corrected the condition to check "index >= length"
            return null;
        }

        Node temp;

        // If index is in the first half of the list
        if (index < (length / 2)) {
            temp = head; // Start traversal from the head
            for (int i = 0; i < index; i++) {
                temp = temp.next; // Move to the next node until reaching the desired index
            }
        } else {
            // If index is in the second half of the list
            temp = tail; // Start traversal from the tail
            for (int i = (length - 1); i > index; i--) {
                temp = temp.prev; // Move to the previous node until reaching the desired index
            }
        }

        return temp; // Return the node at the specified index
    }

    /**
     * Sets the value of the node at the specified index in the doubly linked list.
     *
     * @param index The index of the node, starting from 0.
     * @param value The new value to be assigned to the node.
     * @return true if the value was successfully set, false otherwise (e.g., if
     *         index is out of bounds).
     */
    public boolean set(int index, int value) {
        // Retrieve the node at the specified index
        Node temp = get(index);

        // If the node exists (i.e., index is valid)
        if (temp != null) {
            temp.value = value; // Set the new value to the node
            return true; // Return true indicating successful operation
        }

        return false; // Return false if index is out of bounds
    }

    /**
     * Inserts a new node with the specified value at a given index in the doubly
     * linked list.
     *
     * @param index The index where the new node should be inserted, starting from
     *              0.
     * @param value The value of the new node.
     * @return true if the node was successfully inserted, false otherwise (e.g., if
     *         index is out of bounds).
     */
    public boolean insert(int index, int value) {
        // Check for index out of bounds
        if (index < 0 || index > length) {
            return false;
        }

        // If inserting at the beginning of the list
        if (index == 0) {
            prepend(value); // Use the prepend method to add the node at the beginning
            return true; // Return true indicating successful operation
        }

        // If inserting at the end of the list
        if (index == length) {
            append(value); // Use the append method to add the node at the end
            return true; // Return true indicating successful operation
        }

        // For all other cases (inserting in the middle of the list)

        // Create the new node
        Node newNode = new Node(value);

        // Get the node before the desired index
        Node before = get(index - 1);

        // Get the node currently at the desired index (the node after our new node)
        Node after = before.next;

        // Link the new node with the nodes before and after it
        newNode.prev = before;
        newNode.next = after;

        // Adjust the links of the before and after nodes to point to the new node
        before.next = newNode;
        after.prev = newNode;

        // Increment the length of the list
        length++;

        return true; // Return true indicating successful operation
    }

    /**
     * Removes the node at the specified index from the doubly linked list.
     *
     * @param index The index of the node to be removed, starting from 0.
     * @return The removed node if the operation is successful, null otherwise
     *         (e.g., if index is out of bounds).
     */
    public Node remove(int index) {
        // Check for index out of bounds
        if (index < 0 || index > length) {
            return null;
        }

        // If removing the first node
        if (index == 0) {
            return removeFirst(); // Use the removeFirst method and return the removed node
        }

        // If removing the last node
        if (index == length - 1) {
            return removeLast(); // Use the removeLast method and return the removed node
        }

        // For all other cases (removing a node from the middle of the list)

        // Get the node before the desired index
        Node before = get(index - 1);

        // Get the node to be removed (located at the desired index)
        Node temp = before.next;

        // Get the node after the node to be removed
        Node after = temp.next;

        // Adjust the links of the before and after nodes to bypass the node to be
        // removed
        before.next = after;
        after.prev = before;

        // Nullify the links of the removed node to cleanly detach it from the list
        temp.prev = null;
        temp.next = null;

        // Decrement the length of the list
        length--;

        return temp; // Return the removed node
    }

    /**
     * Swaps the values of the first and last nodes of the doubly linked list.
     * If the list contains fewer than two nodes, the method does nothing.
     */
    public void swapFirstLast() {
        // Check if there are less than two nodes in the list
        if (length < 2) {
            // If true, there's nothing to swap, so we return immediately
            return;
        }

        // Swap the values of the head and tail nodes
        int temp = head.value; // Store the value of the head node in a temporary variable
        head.value = tail.value; // Set the value of the head node to the value of the tail node
        tail.value = temp; // Set the value of the tail node to the original value of the head node (stored
                           // in temp)
    }

    /**
     * Reverses the doubly linked list in-place.
     * If the list contains fewer than two nodes, the method does nothing.
     */
    public void reverse() {
        // Check if there are less than two nodes in the list
        if (length < 2) {
            // If true, there's nothing to reverse, so we return immediately
            return;
        }

        Node current = head; // Start with the head node as the current node
        Node temp; // Temporary node used to hold the next node in the list

        // Traverse through the list
        for (int i = 0; i < length; i++) {
            temp = current.next; // Store the next node in the temporary variable
            current.next = current.prev; // Update the next pointer of the current node to point to its previous node
            current.prev = temp; // Update the previous pointer of the current node to point to its next node
            current = temp; // Move to the next node in the original list
        }

        // Swap the head and tail nodes
        temp = head;
        head = tail;
        tail = temp;
    }

    /**
     * Checks if the doubly linked list represents a palindrome.
     * A palindrome is a sequence that reads the same forward and backward.
     *
     * @return true if the doubly linked list represents a palindrome, false
     *         otherwise.
     */
    public boolean isPalindrome() {
        // If there are 0 or 1 nodes in the list, it's trivially a palindrome
        if (length <= 1)
            return true;

        // Start with nodes at the beginning and the end of the list
        Node forwardNode = head;
        Node backwardNode = tail;

        // Only need to check half the list since we're comparing in pairs from both
        // ends
        for (int i = 0; i < length / 2; i++) {
            // If the values of the nodes being compared are different, it's not a
            // palindrome
            if (forwardNode.value != backwardNode.value)
                return false;

            // Move the pointers towards the center of the list
            forwardNode = forwardNode.next;
            backwardNode = backwardNode.prev;
        }
        // If we've checked all pairs without finding a discrepancy, it's a palindrome
        return true;
    }

    /**
     * Swap every two adjacent nodes of the doubly linked list.
     * If the number of nodes in the list is odd, the last node remains in its
     * position.
     */
    public void swapPairs() {
        // Create a dummy node to simplify edge cases (i.e., swapping head node)
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy; // Used to keep track of the node before the current pair being swapped

        // Traverse the list while there's at least a pair to swap
        while (head != null && head.next != null) {
            // Define the two nodes to be swapped
            Node firstNode = head;
            Node secondNode = head.next;

            // Reorder the nodes to achieve the swap
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Adjust the previous pointers after swapping
            secondNode.prev = prev;
            firstNode.prev = secondNode;
            if (firstNode.next != null) {
                firstNode.next.prev = firstNode;
            }

            // Move the head pointer to the next pair and adjust the prev pointer for the
            // next iteration
            head = firstNode.next;
            prev = firstNode;
        }

        // Update the head of the list after all swaps are done
        head = dummy.next;
        // Ensure the previous pointer of the new head node is set to null
        if (head != null) {
            head.prev = null;
        }
    }
}
