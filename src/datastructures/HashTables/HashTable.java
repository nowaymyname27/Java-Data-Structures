package datastructures.HashTables;

import java.util.ArrayList;

/**
 * A simple implementation of a Hash Table.
 */
public class HashTable {

    // Default size for the hash table.
    private int size = 7;

    // Array to store linked-list chains for collision resolution.
    private Node[] dataMap;

    /**
     * Inner class to represent individual entries in the HashTable.
     */
    public class Node {

        // Key for the entry.
        private String key;

        // Value for the entry.
        private int value;

        // Reference to the next node in the linked-list chain.
        private Node next;

        /**
         * Constructs a new Node with a given key and value.
         * 
         * @param key   The key of the entry.
         * @param value The value of the entry.
         */
        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Default constructor for the HashTable. Initializes the dataMap array
     * with the default size.
     */
    public HashTable() {
        dataMap = new Node[size];
    }

    /**
     * Prints the entire hash table with each bucket's key-value pairs.
     * This method can be used for debugging purposes to visualize the distribution
     * of data in the hash table.
     */
    public void printTable() {
        // Iterate through each bucket in the hash table.
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];

            // Print all key-value pairs in the linked-list chain of the current bucket.
            while (temp != null) {
                System.out.println("    {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    /**
     * Computes the hash value for a given key. The resulting hash value is used
     * to determine the index where the key-value pair should be stored in the hash
     * table.
     * 
     * This method uses a simple polynomial accumulation hashing approach. The key
     * is
     * converted to its character array and each character's ASCII value is
     * multiplied
     * by a prime number (23 in this case) and accumulated to produce the hash.
     * The result is then taken modulo the length of the dataMap to ensure it's
     * within the bounds of the hash table.
     *
     * @param key The key for which the hash needs to be computed.
     * @return The computed hash value (index in the hash table).
     */
    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();

        // Iterate over each character in the key.
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }

        return hash;
    }

    /**
     * Inserts a key-value pair into the hash table. If the bucket (determined by
     * the
     * hash value of the key) is already occupied, the method uses chaining by
     * appending the new node to the end of the linked list in that bucket.
     *
     * @param key   The key to be inserted.
     * @param value The value associated with the key.
     */
    public void set(String key, int value) {
        // Calculate the index for the key using the hash function.
        int index = hash(key);
        Node newNode = new Node(key, value);

        // If the bucket is empty, just add the new node.
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            // If the bucket is occupied, traverse to the end of the linked list in the
            // bucket
            // and append the new node there.
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    /**
     * Retrieves the value associated with the provided key from the hash table.
     * If the key does not exist in the table, the method returns 0.
     *
     * @param key The key whose associated value needs to be returned.
     * @return The value associated with the key if it exists, otherwise 0.
     */
    public int get(String key) {
        // Calculate the index for the key using the hash function.
        int index = hash(key);

        // Start at the head of the linked list in the corresponding bucket.
        Node temp = dataMap[index];

        // Traverse the linked list in the bucket.
        while (temp != null) {
            // If a node with the desired key is found, return its value.
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }

        // If the key is not found, return 0.
        return 0;
    }

    /**
     * Returns an ArrayList containing all the keys present in the hash table.
     * 
     * This method iterates over all buckets in the hash table and traverses each
     * linked list within those buckets to collect all keys.
     *
     * @return ArrayList of all keys in the hash table.
     */
    public ArrayList keys() {
        // Initialize an ArrayList to store the keys.
        ArrayList<String> allKeys = new ArrayList<>();

        // Iterate through each bucket in the hash table.
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];

            // Traverse the linked list in the current bucket and add each key to the
            // ArrayList.
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }

        // Return the ArrayList containing all keys.
        return allKeys;
    }

}