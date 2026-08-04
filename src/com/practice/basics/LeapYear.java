/*
Difficulty: Easy
Time Complexity: O(1)
Space Complexity: O(1)

Question:
Given a year, determine whether it is a Leap Year.

A year is a Leap Year if:
1. It is divisible by 400, OR
2. It is divisible by 4 but not divisible by 100.

Example 1:
Input: 2024
Output: 2024 is a Leap Year

Example 2:
Input: 2023
Output: 2023 is not a Leap Year
*/

package com.practice.basics;

import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Year: ");
        int year = sc.nextInt();

        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is not a Leap Year");
        }

        sc.close();
    }
}