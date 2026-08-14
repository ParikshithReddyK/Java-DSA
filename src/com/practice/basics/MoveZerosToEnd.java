/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(1)

Question:
Given an array of integers, move all zeros to the end of the array
while maintaining the relative order of the non-zero elements.

Example 1:
Input:
6
0 1 0 3 12 0

Output:
1 3 12 0 0 0

Example 2:
Input:
5
1 2 0 4 0

Output:
1 2 4 0 0
*/

package com.practice.basics;

import java.util.Scanner;

public class MoveZerosToEnd {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int index = 0;

        // Move all non-zero elements to the front
        for (int i = 0; i < n; i++) {

            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        // Fill the remaining positions with zeros
        while (index < n) {
            arr[index] = 0;
            index++;
        }

        System.out.println("Array after moving zeros to the end:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}