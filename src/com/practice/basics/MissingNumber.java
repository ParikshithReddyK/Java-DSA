/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(1)

Question:
Given an array containing n distinct numbers taken from the range 1 to n+1,
find the missing number.

Example 1:
Input:
5
1 2 3 5 6

Output:
Missing Number: 4

Example 2:
Input:
4
1 2 4 5

Output:
Missing Number: 3

Approach:
Use XOR.

Properties of XOR:
a ^ a = 0
a ^ 0 = a

Therefore, all numbers that appear both in the expected range
and the array cancel out, leaving only the missing number.
*/

package com.practice.basics;

import java.util.Scanner;

public class MissingNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int xor = 0;

        // XOR all numbers from 1 to n + 1
        for (int i = 1; i <= n + 1; i++) {
            xor ^= i;
        }

        // XOR all elements of the array
        for (int num : arr) {
            xor ^= num;
        }

        System.out.println("Missing Number: " + xor);

        sc.close();
    }
}