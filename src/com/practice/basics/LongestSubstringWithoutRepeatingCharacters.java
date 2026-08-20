/*
Difficulty: Medium
Time Complexity: O(n)
Space Complexity: O(n)

Question:
Given a string, find the length of the longest substring
that contains no repeating characters.

Example 1:
Input:
abcabcbb

Output:
Longest Substring Length: 3

Explanation:
The longest substring without repeating characters is "abc".

Example 2:
Input:
bbbbb

Output:
Longest Substring Length: 1

Example 3:
Input:
pwwkew

Output:
Longest Substring Length: 3

Explanation:
The longest substring without repeating characters is "wke".
*/

package com.practice.basics;

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < str.length(); right++) {

            char ch = str.charAt(right);

            while (set.contains(ch)) {
                set.remove(str.charAt(left));
                left++;
            }

            set.add(ch);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println("Longest Substring Length: " + maxLength);

        sc.close();
    }
}