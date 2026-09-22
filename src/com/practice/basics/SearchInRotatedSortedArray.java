package com.practice.basics;

/*
 * Problem: Search in Rotated Sorted Array
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * Given a rotated sorted array and a target,
 * find the index of the target.
 *
 * Return -1 if the target does not exist.
 *
 * Example:
 *
 * Input:
 * nums = [4,5,6,7,0,1,2]
 * target = 0
 *
 * Output:
 * 4
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            /*
             * Check which half is sorted.
             *
             * If nums[left] <= nums[mid],
             * the left half is sorted.
             */
            if (nums[left] <= nums[mid]) {

                /*
                 * Check whether target lies
                 * inside the sorted left half.
                 */
                if (nums[left] <= target && target < nums[mid]) {

                    // Search left half
                    right = mid - 1;

                } else {

                    // Search right half
                    left = mid + 1;
                }

            } else {

                /*
                 * Otherwise, the right half is sorted.
                 */
                if (nums[mid] < target && target <= nums[right]) {

                    // Search right half
                    left = mid + 1;

                } else {

                    // Search left half
                    right = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        int target = 0;

        int result = search(nums, target);

        System.out.println("Target index: " + result);
    }
}