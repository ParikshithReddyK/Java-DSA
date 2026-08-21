/*
Difficulty: Easy
Time Complexity: O(log n)
Space Complexity: O(1)

Question:
Given a sorted array of integers and a target value,
find the index of the target using Binary Search.

If the target is not present, return -1.

Example 1:
Input:
6
10 20 30 40 50 60
40

Output:
Element found at index: 3

Example 2:
Input:
5
10 20 30 40 50
25

Output:
Element not found
*/

package com.practice.basics;

import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter sorted array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target element: ");
        int target = sc.nextInt();

        int left = 0;
        int right = n - 1;

        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                break;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }

        sc.close();
    }
}