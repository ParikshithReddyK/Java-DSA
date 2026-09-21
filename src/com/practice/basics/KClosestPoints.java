package com.practice.basics;

import java.util.PriorityQueue;
import java.util.Arrays;

/*
 * Problem: K Closest Points to Origin
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * Given an array of points and an integer k,
 * return the k points closest to the origin (0, 0).
 *
 * Example:
 *
 * Input:
 * points = [[1,3],[-2,2],[5,8],[0,1]]
 * k = 2
 *
 * Output:
 * [[-2,2],[0,1]]
 *
 * Time Complexity: O(n log k)
 * Space Complexity: O(k)
 */

public class KClosestPoints {

    public static int[][] kClosest(int[][] points, int k) {

        /*
         * Max-heap.
         *
         * The point with the largest distance
         * will be at the top.
         */
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> distance(b) - distance(a)
        );

        for (int[] point : points) {

            // Add current point
            maxHeap.offer(point);

            /*
             * Keep only k closest points.
             *
             * If we have more than k points,
             * remove the farthest point.
             */
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Create result array
        int[][] result = new int[k][2];

        // Remove points from heap
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    // Calculate squared distance from origin
    public static int distance(int[] point) {

        int x = point[0];
        int y = point[1];

        return x * x + y * y;
    }

    public static void main(String[] args) {

        int[][] points = {
                {1, 3},
                {-2, 2},
                {5, 8},
                {0, 1}
        };

        int k = 2;

        int[][] result = kClosest(points, k);

        System.out.println("K closest points:");

        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}