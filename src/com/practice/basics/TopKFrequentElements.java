package com.practice.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Problem: Top K Frequent Elements
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * Given an integer array, return the k most frequent elements.
 *
 * Example:
 * Input:
 * nums = [1,1,1,2,2,3]
 * k = 2
 *
 * Output:
 * [1,2]
 *
 * Time Complexity: O(n log k)
 * Space Complexity: O(n + k)
 */

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of every number
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(
                    num,
                    frequencyMap.getOrDefault(num, 0) + 1
            );
        }

        /*
         * Min-heap.
         *
         * Each entry contains:
         * [number, frequency]
         *
         * The element with the smallest frequency
         * stays at the top.
         */
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>(
                        (a, b) -> Integer.compare(a[1], b[1])
                );

        // Step 2: Add each number to the heap
        for (Map.Entry<Integer, Integer> entry
                : frequencyMap.entrySet()) {

            minHeap.offer(
                    new int[]{
                            entry.getKey(),
                            entry.getValue()
                    }
            );

            // Keep only k elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 3: Extract the answer
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = topKFrequent(nums, k);

        System.out.print("Top " + k + " frequent elements: ");

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}