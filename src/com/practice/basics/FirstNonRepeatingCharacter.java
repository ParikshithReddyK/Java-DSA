/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(n)

Question:
Given a string, find the first character that appears only once.

Example 1:
Input:
swiss

Output:
First Non-Repeating Character: w

Example 2:
Input:
aabbcde

Output:
First Non-Repeating Character: c
*/

package com.practice.basics;

import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        HashMap<Character, Integer> frequency = new HashMap<>();

        // Count frequency of each character
        for (char ch : str.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        boolean found = false;

        // Find the first character with frequency 1
        for (char ch : str.toCharArray()) {

            if (frequency.get(ch) == 1) {
                System.out.println("First Non-Repeating Character: " + ch);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No non-repeating character found");
        }

        sc.close();
    }
}