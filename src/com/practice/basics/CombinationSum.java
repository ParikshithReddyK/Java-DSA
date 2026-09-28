package com.practice.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem: Combination Sum
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Pattern: Backtracking
 *
 * Example:
 *
 * candidates = [2,3,6,7]
 * target = 7
 *
 * Output:
 * [[2,2,3], [7]]
 *
 * Time Complexity:
 * Exponential in the worst case.
 *
 * Space Complexity:
 * O(target) recursion depth in the typical case.
 */

public class CombinationSum {

    public static List<List<Integer>> combinationSum(
            int[] candidates,
            int target) {

        List<List<Integer>> result = new ArrayList<>();

        /*
         * Sorting makes it easier to stop early
         * when the current number becomes larger
         * than the remaining target.
         */
        Arrays.sort(candidates);

        backtrack(
                candidates,
                target,
                0,
                new ArrayList<>(),
                result
        );

        return result;
    }

    private static void backtrack(
            int[] candidates,
            int remaining,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        /*
         * Base case:
         *
         * Target reached exactly.
         */
        if (remaining == 0) {

            result.add(new ArrayList<>(current));

            return;
        }

        for (int i = start; i < candidates.length; i++) {

            /*
             * Since the array is sorted,
             * anything after this will also be
             * too large.
             */
            if (candidates[i] > remaining) {
                break;
            }

            // Choose
            current.add(candidates[i]);

            /*
             * Use i again because the same number
             * can be selected multiple times.
             */
            backtrack(
                    candidates,
                    remaining - candidates[i],
                    i,
                    current,
                    result
            );

            // Undo the choice
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};

        int target = 7;

        List<List<Integer>> result =
                combinationSum(candidates, target);

        System.out.println("Combinations:");

        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}