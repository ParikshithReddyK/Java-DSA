package com.practice.basics;

import java.util.PriorityQueue;

/*
 * Problem: Kth Largest Element in an Array
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * Given an integer array, find the kth largest element.
 *
 * Example:
 * Input:
 * nums = [3, 2, 1, 5, 6, 4]
 * k = 2
 *
 * Output: 5
 *
 * Time Complexity: O(n log k)
 * Space Complexity: O(k)
 */

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {

        // Min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {

            // Add current number
            minHeap.offer(num);

            // Keep only k largest elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Smallest element among the k largest
        // is the kth largest element.
        return minHeap.peek();
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};

        int k = 2;

        int result = findKthLargest(nums, k);

        System.out.println("Kth largest element: " + result);
    }
}