package com.practice.basics;

/*
 * Problem: 0/1 Knapsack
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * Given weights and values of items and a bag with
 * limited capacity, find the maximum value that can
 * be placed in the bag.
 *
 * Each item can be selected at most once.
 *
 * Example:
 * weights = [1, 3, 4, 5]
 * values  = [1, 4, 5, 7]
 * capacity = 7
 *
 * Output: 9
 *
 * Time Complexity: O(n * capacity)
 * Space Complexity: O(n * capacity)
 */

public class Knapsack01 {

    public static int knapsack(int[] weights, int[] values, int capacity) {

        int n = weights.length;

        // dp[i][w] represents the maximum value we can get
        // using the first i items with capacity w
        int[][] dp = new int[n + 1][capacity + 1];

        // Process each item
        for (int i = 1; i <= n; i++) {

            int currentWeight = weights[i - 1];
            int currentValue = values[i - 1];

            // Try every possible capacity
            for (int w = 1; w <= capacity; w++) {

                // Option 1: Don't take the current item
                dp[i][w] = dp[i - 1][w];

                // Option 2: Take the current item if it fits
                if (currentWeight <= w) {

                    dp[i][w] = Math.max(
                            dp[i][w],
                            currentValue + dp[i - 1][w - currentWeight]
                    );
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {

        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};

        int capacity = 7;

        int result = knapsack(weights, values, capacity);

        System.out.println("Maximum value: " + result);
    }
}