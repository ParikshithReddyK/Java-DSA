/*
Difficulty: Easy
Time Complexity: O(n²)
Best Case Time Complexity: O(n)
Space Complexity: O(1)

Question:
Given an array of integers, sort the array in ascending order
using the Insertion Sort algorithm.

Example 1:
Input:
5
12 11 13 5 6

Output:
5 6 11 12 13

Example 2:
Input:
4
5 3 8 1

Output:
1 3 5 8
*/

package com.practice.basics;

import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("Sorted Array:");

        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}