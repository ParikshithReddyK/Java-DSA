package com.practice.basics;

/*
 * Problem: Edit Distance
 *
 * Difficulty: Hard ⭐⭐⭐⭐⭐
 *
 * Question:
 * Given two strings, find the minimum number of operations
 * required to convert word1 into word2.
 *
 * Allowed operations:
 * 1. Insert a character
 * 2. Delete a character
 * 3. Replace a character
 *
 * Example:
 * word1 = "horse"
 * word2 = "ros"
 *
 * Output: 3
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

public class EditDistance {

    public static int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        // dp[i][j] = minimum operations required to convert
        // first i characters of word1 into first j characters
        // of word2.
        int[][] dp = new int[m + 1][n + 1];

        // Convert a string into an empty string.
        // We need to delete all characters.
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // Convert an empty string into another string.
        // We need to insert all characters.
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                // Characters are the same.
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(
                            insert,
                            Math.min(delete, replace)
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        String word1 = "horse";
        String word2 = "ros";

        int result = minDistance(word1, word2);

        System.out.println("Minimum operations: " + result);
    }
}