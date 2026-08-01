/*
Difficulty: Easy
Time Complexity: O(log n)
Space Complexity: O(1)

Question:
Given an integer, determine whether it is a Palindrome.
A Palindrome number reads the same forward and backward.

Example:
Input: 121
Output: 121 is a Palindrome Number

Input: 123
Output: 123 is not a Palindrome Number
*/

package com.practice.basics;

import java.util.Scanner;

public class PalindromeNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Number: ");
        int num = sc.nextInt();

        int original = num;
        int reverse = 0;

        while (num > 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }

        if (original == reverse) {
            System.out.println(original + " is a Palindrome Number");
        } else {
            System.out.println(original + " is not a Palindrome Number");
        }

        sc.close();
    }
}