/*
Difficulty: Easy
Time Complexity: O(log(min(a, b)))
Space Complexity: O(1)

Question:
Given two positive integers, find their Least Common Multiple (LCM).

The LCM of two numbers is the smallest positive integer
that is divisible by both numbers.

Example 1:
Input:
12
18

Output:
LCM = 36

Example 2:
Input:
5
10

Output:
LCM = 10
*/

package com.practice.basics;

import java.util.Scanner;

public class LCM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        int a = sc.nextInt();

        System.out.print("Enter Second Number: ");
        int b = sc.nextInt();

        int first = a;
        int second = b;

        // Find GCD using Euclidean Algorithm
        while (second != 0) {
            int temp = second;
            second = first % second;
            first = temp;
        }

        int gcd = first;

        int lcm = (a / gcd) * b;

        System.out.println("LCM = " + lcm);

        sc.close();
    }
}