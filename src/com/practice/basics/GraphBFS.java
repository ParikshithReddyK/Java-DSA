package com.practice.basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Graph BFS Traversal
 *
 * Difficulty: Easy-Medium
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 *
 * Question:
 * Given an undirected graph and a starting node,
 * perform Breadth-First Search (BFS).
 *
 * Example:
 *
 *      0
 *     / \
 *    1   2
 *    | \
 *    3  4
 *
 * Starting node = 0
 *
 * Output:
 * 0 1 2 3 4
 */

public class GraphBFS {

    public static void bfs(
            int start,
            List<List<Integer>> graph) {

        boolean[] visited = new boolean[graph.size()];

        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from the given node
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            // Remove the first node
            int current = queue.poll();

            System.out.print(current + " ");

            // Visit all neighbors
            for (int neighbor : graph.get(current)) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;

                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

        int n = 5;

        /*
         * Graph:
         *
         *      0
         *     / \
         *    1   2
         *    | \
         *    3  4
         */

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(0).add(2);
        graph.get(2).add(0);

        graph.get(1).add(3);
        graph.get(3).add(1);

        graph.get(1).add(4);
        graph.get(4).add(1);

        System.out.println("BFS Traversal:");

        bfs(0, graph);
    }
}