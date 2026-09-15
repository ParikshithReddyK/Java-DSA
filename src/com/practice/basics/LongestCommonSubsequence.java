package com.practice.basics;

/*
 * Problem: Longest Common Subsequence
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * Given two strings, find the length of their
 * longest common subsequence.
 *
 * A subsequence keeps the original order of characters,
 * but the characters do not need to be adjacent.
 *
 * Example:
 * text1 = "abcde"
 * text2 = "ace"
 *
 * Output: 3
 *
 * LCS = "ace"
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

public class LongestCommonSubsequence {

    public static int lcs(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        // dp[i][j] represents the length of the LCS
        // between the first i characters of text1
        // and the first j characters of text2.
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                // Characters match
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {

                    // Characters don't match.
                    // Skip one character from either string.
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "ace";

        int result = lcs(text1, text2);

        System.out.println("Length of LCS: " + result);
    }
}