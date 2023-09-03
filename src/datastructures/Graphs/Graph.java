package datastructures.Graphs;

// Required imports
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    // The adjacency list representation of the graph.
    // It uses a HashMap where the key is a vertex and the value is a list of its
    // neighboring vertices.
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    // Method to print the graph's adjacency list representation
    public void printGraph() {
        System.out.println(adjList);
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param vertex The vertex to be added.
     * @return true if the vertex is successfully added (i.e., it didn't exist
     *         before),
     *         false otherwise.
     */
    public boolean addVertex(String vertex) {
        // Check if the vertex already exists in the graph's adjacency list
        if (adjList.get(vertex) == null) {
            // If it doesn't exist, add it to the adjacency list with an empty neighbors
            // list
            adjList.put(vertex, new ArrayList<String>());
            return true; // Return true indicating successful addition
        }
        // If the vertex already exists, return false
        return false;
    }

    /**
     * Adds an edge between two vertices in the graph.
     *
     * @param vertex1 The first vertex of the edge.
     * @param vertex2 The second vertex of the edge.
     * @return true if the edge is successfully added (i.e., both vertices exist in
     *         the graph),
     *         false otherwise.
     */
    public boolean addEdge(String vertex1, String vertex2) {
        // Check if both vertices exist in the graph's adjacency list
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            // If both vertices exist, add the edge by adding each vertex to the other's
            // neighbors list
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true; // Return true indicating successful edge addition
        }
        // If one or both of the vertices do not exist, return false
        return false;
    }

    /**
     * Removes an edge between two vertices in the graph.
     *
     * @param vertex1 The first vertex of the edge.
     * @param vertex2 The second vertex of the edge.
     * @return true if the edge is successfully removed (i.e., both vertices exist
     *         in the graph
     *         and are connected), false otherwise.
     */
    public boolean removeEdge(String vertex1, String vertex2) {
        // Check if both vertices exist in the graph's adjacency list
        if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
            // If both vertices exist, remove the edge by removing each vertex
            // from the other's neighbors list
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true; // Return true indicating successful edge removal
        }
        // If one or both of the vertices do not exist or aren't connected, return false
        return false;
    }

    /**
     * Removes a vertex and its associated edges from the graph.
     *
     * @param vertex The vertex to be removed.
     * @return true if the vertex is successfully removed, false if the adjacency
     *         list
     *         is null or the vertex doesn't exist.
     */
    public boolean removeVertex(String vertex) {
        // Check if the adjacency list is null
        if (adjList == null) {
            return false;
        }

        // If the vertex doesn't exist in the graph, return false
        if (!adjList.containsKey(vertex)) {
            return false;
        }

        // For each vertex that is connected to the given vertex
        for (String otherVertex : adjList.get(vertex)) {
            // Remove the given vertex from the neighbors list of other vertices
            adjList.get(otherVertex).remove(vertex);
        }

        // Remove the vertex from the adjacency list
        adjList.remove(vertex);

        // Return true indicating successful vertex removal
        return true;
    }
}
