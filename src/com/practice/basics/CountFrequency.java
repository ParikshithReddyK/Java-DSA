/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(n)

Question:
Given an array of integers, count the frequency of each element.

Example 1:
Input:
6
1 2 2 3 1 2

Output:
1 -> 2
2 -> 3
3 -> 1

Example 2:
Input:
5
4 4 5 6 5

Output:
4 -> 2
5 -> 2
6 -> 1
*/

package com.practice.basics;

import java.util.HashMap;
import java.util.Scanner;

public class CountFrequency {

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

        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        System.out.println("Frequency of elements:");

        for (int num : frequency.keySet()) {
            System.out.println(num + " -> " + frequency.get(num));
        }

        sc.close();
    }
}