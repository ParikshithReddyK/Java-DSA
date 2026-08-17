/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(n)

Question:
Given a string, reverse the string and print the reversed string.

Example 1:
Input:
Hello

Output:
olleH

Example 2:
Input:
Java

Output:
avaJ
*/

package com.practice.basics;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }

        System.out.println("Reversed String: " + reverse);

        sc.close();
    }
}