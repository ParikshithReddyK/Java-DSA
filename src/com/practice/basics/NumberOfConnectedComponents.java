package com.practice.basics;

import java.util.ArrayList;
import java.util.List;

/*
 * Number of Connected Components
 *
 * Difficulty: Medium
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 *
 * Question:
 * Given n nodes and a list of undirected edges,
 * find the number of connected components.
 *
 * Example:
 *
 * n = 5
 *
 * edges:
 * 0 - 1
 * 1 - 2
 * 3 - 4
 *
 * Graph:
 *
 * 0 - 1 - 2
 *
 * 3 - 4
 *
 * Output:
 * 2
 */

public class NumberOfConnectedComponents {

    // DFS traversal
    public static void dfs(
            int node,
            List<List<Integer>> graph,
            boolean[] visited) {

        // Mark current node as visited
        visited[node] = true;

        // Visit all connected nodes
        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static int countComponents(
            int n,
            int[][] edges) {

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int[] edge : edges) {

            int node1 = edge[0];
            int node2 = edge[1];

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        boolean[] visited = new boolean[n];

        int components = 0;

        // Find every unvisited component
        for (int node = 0; node < n; node++) {

            if (!visited[node]) {

                components++;

                // Visit the entire component
                dfs(node, graph, visited);
            }
        }

        return components;
    }

    public static void main(String[] args) {

        int n = 5;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4}
        };

        int result = countComponents(n, edges);

        System.out.println(
                "Number of Connected Components: " + result
        );
    }
}