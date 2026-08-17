/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(1)

Question:
Given a string, determine whether it is a palindrome.
A palindrome reads the same forward and backward.

Example 1:
Input:
madam

Output:
madam is a Palindrome String

Example 2:
Input:
hello

Output:
hello is not a Palindrome String
*/

package com.practice.basics;

import java.util.Scanner;

public class PalindromeString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        int left = 0;
        int right = str.length() - 1;

        boolean isPalindrome = true;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                isPalindrome = false;
                break;
            }

            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println(str + " is a Palindrome String");
        } else {
            System.out.println(str + " is not a Palindrome String");
        }

        sc.close();
    }
}