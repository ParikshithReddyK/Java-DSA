/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(n)

Question:
Given an array of integers, find the duplicate elements in the array.

Example 1:
Input:
6
1 2 3 4 2 5

Output:
Duplicate Element: 2

Example 2:
Input:
7
1 3 4 2 3 5 6

Output:
Duplicate Element: 3
*/

package com.practice.basics;

import java.util.HashSet;
import java.util.Scanner;

public class FindDuplicate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();

        boolean found = false;

        for (int num : arr) {

            if (set.contains(num)) {
                System.out.println("Duplicate Element: " + num);
                found = true;
                break;
            }

            set.add(num);
        }

        if (!found) {
            System.out.println("No duplicate element found");
        }

        sc.close();
    }
}