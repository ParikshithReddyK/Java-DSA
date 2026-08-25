/*
Difficulty: Medium
Average Time Complexity: O(n log n)
Worst Case Time Complexity: O(n²)
Space Complexity: O(log n) average due to recursion

Question:
Given an array of integers, sort the array in ascending order
using the Quick Sort algorithm.

Quick Sort follows the Divide and Conquer approach:
1. Choose a pivot element.
2. Partition the array around the pivot.
3. Recursively sort the left and right partitions.

Example:
Input:
6
10 7 8 9 1 5

Output:
1 5 7 8 9 10
*/

package com.practice.basics;

import java.util.Scanner;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {

                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted Array:");

        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}