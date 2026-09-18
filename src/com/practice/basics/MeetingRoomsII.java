package com.practice.basics;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Problem: Meeting Rooms II
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * Given an array of meeting intervals, find the minimum
 * number of meeting rooms required so that no meetings overlap.
 *
 * Example:
 * Input:
 * [[0,30], [5,10], [15,20]]
 *
 * Output:
 * 2
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] meetings) {

        if (meetings == null || meetings.length == 0) {
            return 0;
        }

        // Sort meetings by start time
        Arrays.sort(
                meetings,
                (a, b) -> Integer.compare(a[0], b[0])
        );

        // Min-heap containing the end times
        // of meetings currently using rooms.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // First meeting needs a room
        minHeap.offer(meetings[0][1]);

        for (int i = 1; i < meetings.length; i++) {

            int currentStart = meetings[i][0];
            int currentEnd = meetings[i][1];

            // If the earliest room is free,
            // reuse that room.
            if (minHeap.peek() <= currentStart) {
                minHeap.poll();
            }

            // Assign the current meeting to a room
            minHeap.offer(currentEnd);
        }

        // Number of elements in the heap =
        // number of rooms currently required.
        return minHeap.size();
    }

    public static void main(String[] args) {

        int[][] meetings = {
            {0, 30},
            {5, 10},
            {15, 20}
        };

        int result = minMeetingRooms(meetings);

        System.out.println("Minimum meeting rooms: " + result);
    }
}