package com.practice.basics;

import java.util.ArrayList;
import java.util.List;

/*
 * Graph DFS Traversal
 *
 * Difficulty: Easy-Medium
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 *
 * Question:
 * Given an undirected graph and a starting node,
 * perform Depth-First Search (DFS).
 *
 * Example:
 *
 *        0
 *       / \
 *      1   2
 *     / \
 *    3   4
 *
 * Starting node = 0
 *
 * Output:
 * 0 1 3 4 2
 */

public class GraphDFS {

    public static void dfs(
            int current,
            List<List<Integer>> graph,
            boolean[] visited) {

        // Mark current node as visited
        visited[current] = true;

        System.out.print(current + " ");

        // Visit every unvisited neighbor
        for (int neighbor : graph.get(current)) {

            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static void main(String[] args) {

        int n = 5;

        /*
         * Graph:
         *
         *        0
         *       / \
         *      1   2
         *     / \
         *    3   4
         */

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 0 - 1
        graph.get(0).add(1);
        graph.get(1).add(0);

        // 0 - 2
        graph.get(0).add(2);
        graph.get(2).add(0);

        // 1 - 3
        graph.get(1).add(3);
        graph.get(3).add(1);

        // 1 - 4
        graph.get(1).add(4);
        graph.get(4).add(1);

        boolean[] visited = new boolean[n];

        System.out.println("DFS Traversal:");

        dfs(0, graph, visited);
    }
}