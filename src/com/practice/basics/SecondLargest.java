/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(1)

Question:
Given an array of integers, find the second largest element
without sorting the array.

Example 1:
Input:
5
10 25 7 40 15

Output:
Second Largest Element: 25

Example 2:
Input:
6
12 35 1 10 34 1

Output:
Second Largest Element: 34
*/

package com.practice.basics;

import java.util.Scanner;

public class SecondLargest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("Second largest element does not exist");
        } else {
            System.out.println("Second Largest Element: " + secondLargest);
        }

        sc.close();
    }
}