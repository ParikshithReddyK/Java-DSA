/*
Difficulty: Easy
Time Complexity: O(log n)
Space Complexity: O(1)

Question:
Given an integer, determine whether it is an Armstrong Number.

An Armstrong Number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.

Example:
Input: 153
Output: 153 is an Armstrong Number

Explanation:
1³ + 5³ + 3³ = 153

Input: 125
Output: 125 is not an Armstrong Number
*/

package com.practice.basics;

import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Number: ");
        int num = sc.nextInt();

        int original = num;
        int digits = 0;
        int sum = 0;

        int temp = num;

        // Count number of digits
        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        temp = num;

        // Calculate Armstrong sum
        while (temp > 0) {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, digits);
            temp /= 10;
        }

        if (sum == original) {
            System.out.println(original + " is an Armstrong Number");
        } else {
            System.out.println(original + " is not an Armstrong Number");
        }

        sc.close();
    }
}