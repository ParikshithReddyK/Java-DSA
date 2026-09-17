package com.practice.basics;

/*
 * Problem: Product of Array Except Self
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * Given an integer array, return an array where each
 * element is the product of all elements except itself.
 *
 * Do not use division.
 *
 * Example:
 * Input:  [1, 2, 3, 4]
 * Output: [24, 12, 8, 6]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) extra space
 * (excluding the output array)
 */

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        // Initially, there is no product on the left.
        int prefixProduct = 1;

        // Store product of all elements to the left
        // of each position.
        for (int i = 0; i < n; i++) {

            result[i] = prefixProduct;

            prefixProduct *= nums[i];
        }

        // Product of elements to the right
        int suffixProduct = 1;

        // Multiply the left product by the right product.
        for (int i = n - 1; i >= 0; i--) {

            result[i] *= suffixProduct;

            suffixProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        System.out.print("Result: ");

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}