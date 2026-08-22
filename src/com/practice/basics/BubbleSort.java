/*
Difficulty: Easy
Time Complexity: O(n²)
Space Complexity: O(1)

Question:
Given an array of integers, sort the array in ascending order
using the Bubble Sort algorithm.

Example 1:
Input:
5
5 3 8 1 2

Output:
1 2 3 5 8

Example 2:
Input:
4
10 5 2 8

Output:
2 5 8 10
*/

package com.practice.basics;

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // Stop if the array is already sorted
            if (!swapped) {
                break;
            }
        }

        System.out.println("Sorted Array:");

        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}