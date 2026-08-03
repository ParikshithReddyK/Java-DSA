/*
Difficulty: Easy
Time Complexity: O(log n)
Space Complexity: O(1)

Question:
Given an integer, calculate the sum of all its digits.

Example 1:
Input: 12345
Output: Sum of Digits: 15

Explanation:
1 + 2 + 3 + 4 + 5 = 15

Example 2:
Input: 908
Output: Sum of Digits: 17
*/

package com.practice.basics;

import java.util.Scanner;

public class SumOfDigits {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Number: ");
        int num = sc.nextInt();

        int sum = 0;

        while (num > 0) {

            int digit = num % 10;
            sum += digit;
            num /= 10;
        }

        System.out.println("Sum of Digits: " + sum);

        sc.close();
    }
}