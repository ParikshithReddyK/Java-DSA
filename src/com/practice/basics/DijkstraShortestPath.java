package com.practice.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Dijkstra's Shortest Path Algorithm
 *
 * Difficulty: Medium-Hard
 *
 * Time Complexity: O((V + E) log V)
 * Space Complexity: O(V + E)
 *
 * Question:
 * Given a weighted graph and a starting node,
 * find the shortest distance from the starting node
 * to every other node.
 *
 * IMPORTANT:
 * Dijkstra works when edge weights are NON-NEGATIVE.
 */

public class DijkstraShortestPath {

    // Represents an edge
    static class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Represents a node in the priority queue
    static class NodeDistance implements Comparable<NodeDistance> {

        int node;
        int distance;

        NodeDistance(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(NodeDistance other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static int[] dijkstra(
            List<List<Edge>> graph,
            int source) {

        int n = graph.size();

        // Initially, all distances are infinity
        int[] distance = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);

        // Distance from source to itself is 0
        distance[source] = 0;

        // Priority Queue gives us the node
        // with the smallest current distance
        PriorityQueue<NodeDistance> priorityQueue =
                new PriorityQueue<>();

        priorityQueue.add(
                new NodeDistance(source, 0)
        );

        while (!priorityQueue.isEmpty()) {

            NodeDistance current =
                    priorityQueue.poll();

            int currentNode = current.node;
            int currentDistance = current.distance;

            /*
             * Ignore outdated entries.
             *
             * A node can be added to the priority queue
             * multiple times with different distances.
             */
            if (currentDistance != distance[currentNode]) {
                continue;
            }

            // Check all neighboring nodes
            for (Edge edge : graph.get(currentNode)) {

                int newDistance =
                        currentDistance + edge.weight;

                /*
                 * If we found a shorter path,
                 * update the distance.
                 */
                if (newDistance < distance[edge.destination]) {

                    distance[edge.destination] = newDistance;

                    priorityQueue.add(
                            new NodeDistance(
                                    edge.destination,
                                    newDistance
                            )
                    );
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {

        int n = 4;

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        /*
         * Graph:
         *
         *       4
         *   0 ------> 1
         *   |
         *  1|
         *   ↓
         *   2 ------> 3
         *       2
         *
         * 1 -> 3 also has weight 1
         */

        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 1));

        graph.get(2).add(new Edge(3, 2));

        graph.get(1).add(new Edge(3, 1));

        int source = 0;

        int[] distances =
                dijkstra(graph, source);

        System.out.println(
                "Shortest distances from node " + source + ":"
        );

        for (int i = 0; i < distances.length; i++) {

            System.out.println(
                    "Node " + i + " = " + distances[i]
            );
        }
    }
}