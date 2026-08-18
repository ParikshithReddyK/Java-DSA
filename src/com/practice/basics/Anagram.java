/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(1)

Question:
Given two strings, determine whether they are anagrams of each other.

Two strings are anagrams if they contain the same characters
with the same frequency, but the order can be different.

Example 1:
Input:
listen
silent

Output:
The strings are Anagrams

Example 2:
Input:
hello
world

Output:
The strings are not Anagrams
*/

package com.practice.basics;

import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first String: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second String: ");
        String str2 = sc.nextLine();

        if (str1.length() != str2.length()) {
            System.out.println("The strings are not Anagrams");
            sc.close();
            return;
        }

        int[] frequency = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            frequency[str1.charAt(i)]++;
            frequency[str2.charAt(i)]--;
        }

        boolean isAnagram = true;

        for (int count : frequency) {
            if (count != 0) {
                isAnagram = false;
                break;
            }
        }

        if (isAnagram) {
            System.out.println("The strings are Anagrams");
        } else {
            System.out.println("The strings are not Anagrams");
        }

        sc.close();
    }
}