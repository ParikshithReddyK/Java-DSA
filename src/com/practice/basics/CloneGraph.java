package com.practice.basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem: Clone Graph
 *
 * Difficulty: Medium
 *
 * Pattern: DFS + HashMap
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 *
 * V = number of vertices
 * E = number of edges
 */

public class CloneGraph {

    /*
     * Graph node.
     */
    static class Node {

        int val;

        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    /*
     * Maps original nodes to cloned nodes.
     */
    private static Map<Node, Node> clonedNodes = new HashMap<>();

    public static Node cloneGraph(Node node) {

        // Empty graph
        if (node == null) {
            return null;
        }

        /*
         * If this node has already been cloned,
         * return the existing clone.
         */
        if (clonedNodes.containsKey(node)) {
            return clonedNodes.get(node);
        }

        /*
         * Create a clone of the current node.
         */
        Node clone = new Node(node.val);

        /*
         * Store it BEFORE visiting neighbors.
         *
         * This is important for cycles.
         */
        clonedNodes.put(node, clone);

        /*
         * Clone every neighbor.
         */
        for (Node neighbor : node.neighbors) {

            Node clonedNeighbor = cloneGraph(neighbor);

            clone.neighbors.add(clonedNeighbor);
        }

        return clone;
    }

    /*
     * Helper method to print graph.
     */
    public static void printGraph(Node node) {

        if (node == null) {
            return;
        }

        Map<Node, Boolean> visited = new HashMap<>();

        printGraphDFS(node, visited);
    }

    private static void printGraphDFS(
            Node node,
            Map<Node, Boolean> visited) {

        if (visited.containsKey(node)) {
            return;
        }

        visited.put(node, true);

        System.out.print(
                node.val + " -> "
        );

        for (Node neighbor : node.neighbors) {

            System.out.print(
                    neighbor.val + " "
            );
        }

        System.out.println();

        for (Node neighbor : node.neighbors) {

            printGraphDFS(
                    neighbor,
                    visited
            );
        }
    }

    public static void main(String[] args) {

        /*
         * Create graph:
         *
         *     1 ----- 2
         *     |       |
         *     |       |
         *     4 ----- 3
         */

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        System.out.println("Original graph:");

        printGraph(node1);

        /*
         * Clone graph.
         */
        Node clonedGraph = cloneGraph(node1);

        System.out.println("\nCloned graph:");

        printGraph(clonedGraph);
    }
}