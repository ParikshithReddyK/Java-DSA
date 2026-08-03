/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(1)

Question:
Given a non-negative integer, calculate its factorial.

Factorial of a number n is the product of all positive integers less than or equal to n.

Example 1:
Input: 5
Output: Factorial of 5 is 120

Explanation:
5! = 5 × 4 × 3 × 2 × 1 = 120

Example 2:
Input: 0
Output: Factorial of 0 is 1
*/

package com.practice.basics;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Number: ");
        int num = sc.nextInt();

        long factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        System.out.println("Factorial of " + num + " is " + factorial);

        sc.close();
    }
}