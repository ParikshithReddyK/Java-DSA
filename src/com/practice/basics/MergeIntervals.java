package com.practice.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem: Merge Intervals
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * Given an array of intervals, merge all overlapping intervals.
 *
 * Example:
 * Input:
 * [[1,3], [2,6], [8,10], [15,18]]
 *
 * Output:
 * [[1,6], [8,10], [15,18]]
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by their starting value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // Start with the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // Intervals overlap
            if (currentStart <= end) {

                end = Math.max(end, currentEnd);

            } else {

                // No overlap, save previous interval
                merged.add(new int[]{start, end});

                start = currentStart;
                end = currentEnd;
            }
        }

        // Add the final interval
        merged.add(new int[]{start, end});

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        int[][] result = merge(intervals);

        System.out.println("Merged intervals:");

        for (int[] interval : result) {
            System.out.println(
                "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }
}