package com.practice.basics;

/*
 * Problem: House Robber
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * You are given an array where each element represents
 * the money available in a house.
 *
 * You cannot rob two adjacent houses.
 * Find the maximum amount of money you can rob.
 *
 * Example:
 * Input:  [2, 7, 9, 3, 1]
 * Output: 12
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class HouseRobber {

    public static int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        // Maximum money two houses before
        int prev2 = 0;

        // Maximum money from previous house
        int prev1 = 0;

        for (int money : nums) {

            // Option 1: Skip current house
            // Option 2: Rob current house
            int current = Math.max(prev1, prev2 + money);

            // Move forward
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {

        int[] houses = {2, 7, 9, 3, 1};

        int result = rob(houses);

        System.out.println("Maximum money: " + result);
    }
}