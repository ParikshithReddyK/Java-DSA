/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(n)

Question:
Given a string, remove all duplicate characters while preserving
the order of their first occurrence.

Example 1:
Input:
programming

Output:
progamin

Example 2:
Input:
hello

Output:
helo
*/

package com.practice.basics;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicateCharacters {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        HashSet<Character> set = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {

            if (set.add(ch)) {
                result.append(ch);
            }
        }

        System.out.println("String after removing duplicates: " + result);

        sc.close();
    }
}