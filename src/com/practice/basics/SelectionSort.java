/*
Difficulty: Easy
Time Complexity: O(n²)
Space Complexity: O(1)

Question:
Given an array of integers, sort the array in ascending order
using the Selection Sort algorithm.

Example 1:
Input:
5
64 25 12 22 11

Output:
11 12 22 25 64

Example 2:
Input:
4
5 3 8 1

Output:
1 3 5 8
*/

package com.practice.basics;

import java.util.Scanner;

public class SelectionSort {

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

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.println("Sorted Array:");

        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}