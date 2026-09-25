package com.practice.basics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Problem: Word Break
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * Given a string s and a dictionary of words,
 * determine whether s can be segmented into
 * one or more dictionary words.
 *
 * Example:
 *
 * Input:
 * s = "leetcode"
 * wordDict = ["leet", "code"]
 *
 * Output:
 * true
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();

        /*
         * Convert dictionary to HashSet
         * for fast lookup.
         */
        Set<String> words = new HashSet<>(wordDict);

        /*
         * dp[i] means:
         *
         * The first i characters of s
         * can be successfully segmented.
         */
        boolean[] dp = new boolean[n + 1];

        /*
         * Empty string is considered valid.
         */
        dp[0] = true;

        /*
         * Check every possible ending position.
         */
        for (int i = 1; i <= n; i++) {

            /*
             * Try every possible starting position.
             */
            for (int j = 0; j < i; j++) {

                /*
                 * If the first j characters are valid
                 * and s[j...i] is a dictionary word,
                 * then the first i characters are valid.
                 */
                if (dp[j]
                        && words.contains(s.substring(j, i))) {

                    dp[i] = true;

                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        String s = "leetcode";

        List<String> wordDict = Arrays.asList(
                "leet",
                "code"
        );

        boolean result = wordBreak(s, wordDict);

        System.out.println("Can segment string: " + result);
    }
}