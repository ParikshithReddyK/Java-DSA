package com.practice.basics;

/*
 * Problem: Maximum Subarray
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * Given an integer array, find the contiguous subarray
 * with the largest sum.
 *
 * Example:
 * Input:  [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Output: 6
 *
 * Maximum subarray:
 * [4, -1, 2, 1]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class MaximumSubarray {

    public static int maxSubarraySum(int[] nums) {

        // Start with the first element
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Either start a new subarray
            // or extend the previous one
            currentSum = Math.max(
                    nums[i],
                    currentSum + nums[i]
            );

            // Update the maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {
            -2, 1, -3, 4, -1, 2, 1, -5, 4
        };

        int result = maxSubarraySum(nums);

        System.out.println("Maximum subarray sum: " + result);
    }
}