/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(n)

Question:
Given an array of integers and a target value, find two elements
whose sum is equal to the target.

Return the indices of those two elements.

Example:
Input:
5
2 7 11 15 3
9

Output:
Indices: 0 1

Explanation:
arr[0] + arr[1] = 2 + 7 = 9
*/

package com.practice.basics;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target: ");
        int target = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        boolean found = false;

        for (int i = 0; i < n; i++) {

            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                System.out.println("Indices: " + map.get(complement) + " " + i);
                found = true;
                break;
            }

            map.put(arr[i], i);
        }

        if (!found) {
            System.out.println("No pair found");
        }

        sc.close();
    }
}