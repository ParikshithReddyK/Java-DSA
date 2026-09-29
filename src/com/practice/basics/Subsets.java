package com.practice.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem: Subsets
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Pattern: Backtracking
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * [
 *   [],
 *   [1],
 *   [2],
 *   [1,2],
 *   [3],
 *   [1,3],
 *   [2,3],
 *   [1,2,3]
 * ]
 *
 * Number of subsets = 2^n
 *
 * Time Complexity: O(n * 2^n)
 * Space Complexity: O(n) recursion stack
 *                   + O(n * 2^n) for output
 */

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(
                nums,
                0,
                new ArrayList<>(),
                result
        );

        return result;
    }

    private static void backtrack(
            int[] nums,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        /*
         * Every state represents a valid subset.
         *
         * Therefore, add the current subset
         * before making further choices.
         */
        result.add(new ArrayList<>(current));

        /*
         * Try every remaining element.
         */
        for (int i = start; i < nums.length; i++) {

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(
                    nums,
                    i + 1,
                    current,
                    result
            );

            // Undo choice
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        List<List<Integer>> result = subsets(nums);

        System.out.println("All subsets:");

        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}