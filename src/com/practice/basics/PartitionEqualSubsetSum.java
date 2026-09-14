package com.practice.basics;

/*
 * Problem: Partition Equal Subset Sum
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * Given an array of positive integers, determine whether
 * the array can be divided into two subsets with equal sums.
 *
 * Example:
 * Input:  [1, 5, 11, 5]
 * Output: true
 *
 * Explanation:
 * [1, 5, 5] = 11
 * [11]      = 11
 *
 * Time Complexity: O(n * sum)
 * Space Complexity: O(n * sum)
 */

public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {

        int totalSum = 0;

        // Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        // An odd total cannot be divided into two equal parts
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        int n = nums.length;

        // dp[i][sum] means:
        // Can we make "sum" using the first i numbers?
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Sum 0 is always possible by selecting no elements
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Process each number
        for (int i = 1; i <= n; i++) {

            int currentNumber = nums[i - 1];

            for (int sum = 1; sum <= target; sum++) {

                // Option 1: Skip current number
                dp[i][sum] = dp[i - 1][sum];

                // Option 2: Take current number
                if (currentNumber <= sum) {

                    dp[i][sum] = dp[i][sum]
                            || dp[i - 1][sum - currentNumber];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};

        boolean result = canPartition(nums);

        System.out.println("Can partition: " + result);
    }
}