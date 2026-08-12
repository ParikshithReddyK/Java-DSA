/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(1)

Question:
Given an array of integers, find the largest element in the array.

Example 1:
Input:
5
10 25 7 40 15

Output:
Largest Element: 40

Example 2:
Input:
4
3 8 2 6

Output:
Largest Element: 8
*/

package com.practice.basics;

import java.util.Scanner;

public class FindLargestElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int largest = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        System.out.println("Largest Element: " + largest);

        sc.close();
    }
}