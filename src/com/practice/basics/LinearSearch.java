/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(1)

Question:
Given an array of integers and a target element, find the index
of the target using Linear Search.

If the target is not present, return -1.

Example 1:
Input:
5
10 25 30 45 50
30

Output:
Element found at index: 2

Example 2:
Input:
5
10 25 30 45 50
20

Output:
Element not found
*/

package com.practice.basics;

import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target element: ");
        int target = sc.nextInt();

        int result = -1;

        for (int i = 0; i < n; i++) {

            if (arr[i] == target) {
                result = i;
                break;
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