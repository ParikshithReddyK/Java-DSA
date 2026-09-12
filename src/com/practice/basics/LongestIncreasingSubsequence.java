package com.practice.basics;

/*
 * Problem: Longest Increasing Subsequence
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * Given an integer array, find the length of the
 * longest strictly increasing subsequence.
 *
 * A subsequence does not need to contain adjacent elements.
 *
 * Example:
 * Input:  [10, 9, 2, 5, 3, 7, 101, 18]
 * Output: 4
 *
 * One possible LIS:
 * 2 -> 5 -> 7 -> 101
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        // dp[i] = longest increasing subsequence
        // ending at index i
        int[] dp = new int[n];

        int maxLength = 1;

        // Every element by itself is a subsequence of length 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Check every previous element
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                // If nums[j] can come before nums[i]
                if (nums[j] < nums[i]) {

                    dp[i] = Math.max(
                            dp[i],
                            dp[j] + 1
                    );
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int result = lengthOfLIS(nums);

        System.out.println("Length of LIS: " + result);
    }
}