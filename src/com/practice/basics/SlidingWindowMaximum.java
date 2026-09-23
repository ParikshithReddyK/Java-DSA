package com.practice.basics;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * Problem: Sliding Window Maximum
 *
 * Difficulty: Hard ⭐⭐⭐⭐⭐
 *
 * Question:
 * Given an integer array nums and an integer k,
 * find the maximum value in every window of size k.
 *
 * Example:
 *
 * Input:
 * nums = [1,3,-1,-3,5,3,6,7]
 * k = 3
 *
 * Output:
 * [3,3,5,5,6,7]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        // Number of windows
        int[] result = new int[n - k + 1];

        // Stores indices
        Deque<Integer> deque = new ArrayDeque<>();

        int resultIndex = 0;

        for (int i = 0; i < n; i++) {

            /*
             * Step 1:
             * Remove indices that are outside
             * the current window.
             */
            while (!deque.isEmpty()
                    && deque.peekFirst() <= i - k) {

                deque.pollFirst();
            }

            /*
             * Step 2:
             * Remove smaller elements from the back.
             *
             * They can never become the maximum
             * while nums[i] is in the window.
             */
            while (!deque.isEmpty()
                    && nums[deque.peekLast()] <= nums[i]) {

                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            /*
             * Step 3:
             * Once we have a complete window,
             * the front contains the maximum.
             */
            if (i >= k - 1) {

                result[resultIndex] = nums[deque.peekFirst()];

                resultIndex++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {
                1, 3, -1, -3, 5, 3, 6, 7
        };

        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        System.out.println("Sliding window maximum:");
        System.out.println(Arrays.toString(result));
    }
}