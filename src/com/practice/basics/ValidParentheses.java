/*
Difficulty: Easy

Time Complexity: O(n)
Space Complexity: O(n)

Question:
Given a string containing only '(', ')', '{', '}', '[' and ']',
determine whether the brackets are valid.

A string is valid when:
1. Every opening bracket has a matching closing bracket.
2. Brackets are closed in the correct order.

Example 1:
Input:
{[()]}

Output:
Valid Parentheses

Example 2:
Input:
{[(])}

Output:
Invalid Parentheses

Example 3:
Input:
()

Output:
Valid Parentheses
*/

package com.practice.basics;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String str) {

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {

            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {

                stack.push(ch);

            } else {

                // Closing bracket without opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {

                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter parentheses: ");
        String str = sc.nextLine();

        if (isValid(str)) {
            System.out.println("Valid Parentheses");
        } else {
            System.out.println("Invalid Parentheses");
        }

        sc.close();
    }
}