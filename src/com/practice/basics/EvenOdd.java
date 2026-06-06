/*
Problem: Check Whether a Number is Even or Odd
Difficulty: Easy
Time Complexity: O(1)
Space Complexity: O(1)
*/

package com.practice.basics;

import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Number: ");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println(num + " is an even number");
        } else {
            System.out.println(num + " is an odd number");
        }

        sc.close();
    }
}
