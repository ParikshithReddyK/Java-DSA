/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(n)

Question:
Given an array of integers, find the first element that appears
only once in the array.

Example 1:
Input:
7
4 5 1 2 1 4 5

Output:
First Non-Repeating Element: 2

Example 2:
Input:
6
1 2 3 2 1 4

Output:
First Non-Repeating Element: 3
*/

package com.practice.basics;

import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeatingElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> frequency = new HashMap<>();

        // Count frequency of each element
        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        boolean found = false;

        // Find the first element with frequency 1
        for (int num : arr) {

            if (frequency.get(num) == 1) {
                System.out.println("First Non-Repeating Element: " + num);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No non-repeating element found");
        }

        sc.close();
    }
}