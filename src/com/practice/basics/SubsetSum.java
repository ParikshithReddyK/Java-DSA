package com.practice.basics;

/*
 * Problem: Subset Sum
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * Given an array of positive integers and a target sum,
 * determine whether there exists a subset whose elements
 * add up exactly to the target.
 *
 * Each element can be used at most once.
 *
 * Example:
 * Input:
 * nums = [2, 3, 7, 8, 10]
 * target = 11
 *
 * Output: true
 *
 * Explanation:
 * 3 + 8 = 11
 *
 * Time Complexity: O(n * target)
 * Space Complexity: O(n * target)
 */

public class SubsetSum {

    public static boolean subsetSum(int[] nums, int target) {

        int n = nums.length;

        // dp[i][sum] means:
        // Can we make "sum" using the first i elements?
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Sum 0 is always possible by choosing no elements
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Process each number
        for (int i = 1; i <= n; i++) {

            int currentNumber = nums[i - 1];

            for (int sum = 1; sum <= target; sum++) {

                // Option 1: Don't take the current number
                dp[i][sum] = dp[i - 1][sum];

                // Option 2: Take the current number
                if (currentNumber <= sum) {

                    dp[i][sum] = dp[i][sum]
                            || dp[i - 1][sum - currentNumber];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 7, 8, 10};

        int target = 11;

        boolean result = subsetSum(nums, target);

        System.out.println("Subset exists: " + result);
    }
}