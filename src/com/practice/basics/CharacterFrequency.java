/*
Difficulty: Easy
Time Complexity: O(n)
Space Complexity: O(n)

Question:
Given a string, count the frequency of each character.

Example 1:
Input:
programming

Output:
p -> 1
r -> 2
o -> 1
g -> 2
a -> 1
m -> 2
i -> 1
n -> 1

Example 2:
Input:
hello

Output:
h -> 1
e -> 1
l -> 2
o -> 1
*/

package com.practice.basics;

import java.util.HashMap;
import java.util.Scanner;

public class CharacterFrequency {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        HashMap<Character, Integer> frequency = new HashMap<>();

        for (char ch : str.toCharArray()) {

            if (ch != ' ') {
                frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
            }
        }

        System.out.println("Character Frequency:");

        for (char ch : frequency.keySet()) {
            System.out.println(ch + " -> " + frequency.get(ch));
        }

        sc.close();
    }
}