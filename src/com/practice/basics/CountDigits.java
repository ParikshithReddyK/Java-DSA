/*
Difficulty: Easy
Time Complexity: O(log n)
Space Complexity: O(1)

Question:
Given an integer, count the total number of digits present in it.

Example 1:
Input: 12345
Output: Number of Digits: 5

Example 2:
Input: 7
Output: Number of Digits: 1
*/

package com.practice.basics;

import java.util.Scanner;

public class CountDigits {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Number: ");
        int num = sc.nextInt();

        int count = 0;

        if (num == 0) {
            count = 1;
        } else {
            while (num != 0) {
                count++;
                num /= 10;
            }
        }

        System.out.println("Number of Digits: " + count);

        sc.close();
    }
}