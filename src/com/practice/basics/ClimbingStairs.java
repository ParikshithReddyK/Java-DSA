package com.practice.basics;

/*
 * Problem: Climbing Stairs
 *
 * Difficulty: Easy ⭐⭐⭐
 *
 * Question:
 * You are climbing a staircase with n steps.
 * You can climb either 1 step or 2 steps at a time.
 * Find the number of distinct ways to reach the top.
 *
 * Example:
 * Input: 5
 * Output: 8
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ClimbingStairs {

    public static int climbStairs(int n) {

        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }

        // Ways to reach previous two steps
        int prev2 = 1;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {

            int current = prev1 + prev2;

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {

        int n = 5;

        int result = climbStairs(n);

        System.out.println("Number of ways: " + result);
    }
}