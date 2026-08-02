/*
Difficulty: Easy
Time Complexity: O(log n)
Space Complexity: O(1)

Question:
Given an integer, reverse its digits.

Example 1:
Input: 12345
Output: 54321

Example 2:
Input: 1002
Output: 2001
*/

package com.practice.basics;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Number: ");
        int num = sc.nextInt();

        int reverse = 0;

        while (num > 0) {

            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }

        System.out.println("Reversed Number: " + reverse);

        sc.close();
    }
}