package com.practice.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem: Permutations
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
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * Time Complexity: O(n * n!)
 * Space Complexity: O(n)
 *                   excluding output
 */

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        /*
         * Tracks whether an element is already
         * present in the current permutation.
         */
        boolean[] used = new boolean[nums.length];

        backtrack(
                nums,
                used,
                new ArrayList<>(),
                result
        );

        return result;
    }

    private static void backtrack(
            int[] nums,
            boolean[] used,
            List<Integer> current,
            List<List<Integer>> result) {

        /*
         * If current permutation contains
         * all elements, we have a complete answer.
         */
        if (current.size() == nums.length) {

            result.add(new ArrayList<>(current));

            return;
        }

        /*
         * Try every element.
         */
        for (int i = 0; i < nums.length; i++) {

            /*
             * Don't use an element twice
             * in the same permutation.
             */
            if (used[i]) {
                continue;
            }

            // Choose
            used[i] = true;
            current.add(nums[i]);

            // Explore
            backtrack(
                    nums,
                    used,
                    current,
                    result
            );

            // Undo choice
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        List<List<Integer>> result = permute(nums);

        System.out.println("Permutations:");

        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }
}