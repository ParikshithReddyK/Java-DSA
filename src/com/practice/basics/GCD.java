/*
Difficulty: Easy
Time Complexity: O(log(min(a, b)))
Space Complexity: O(1)

Question:
Given two positive integers, find their Greatest Common Divisor (GCD)
using the Euclidean Algorithm.

The GCD of two numbers is the largest positive integer
that divides both numbers without leaving a remainder.

Example 1:
Input:
54
24

Output:
GCD = 6

Example 2:
Input:
20
30

Output:
GCD = 10
*/

package com.practice.basics;

import java.util.Scanner;

public class GCD {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        int a = sc.nextInt();

        System.out.print("Enter Second Number: ");
        int b = sc.nextInt();

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        System.out.println("GCD = " + a);

        sc.close();
    }
}