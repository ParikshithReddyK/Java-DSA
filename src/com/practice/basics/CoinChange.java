package com.practice.basics;

/*
 * Problem: Coin Change
 *
 * Difficulty: Medium ⭐⭐⭐⭐
 *
 * Question:
 * Given an array of coin denominations and a target amount,
 * find the minimum number of coins required to make that amount.
 *
 * You can use each coin any number of times.
 *
 * Example:
 * Coins = [1, 2, 5]
 * Amount = 11
 *
 * Output: 3
 *
 * Explanation:
 * 5 + 5 + 1 = 11
 *
 * Time Complexity: O(amount * number of coins)
 * Space Complexity: O(amount)
 */

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {

        // dp[i] = minimum number of coins needed to make amount i
        int[] dp = new int[amount + 1];

        // Initialize with an impossible large value
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        // Calculate the minimum coins for every amount
        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {

            for (int coin : coins) {

                // We can use this coin only if it does not exceed
                // the current amount
                if (coin <= currentAmount) {

                    dp[currentAmount] = Math.min(
                            dp[currentAmount],
                            dp[currentAmount - coin] + 1
                    );
                }
            }
        }

        // If amount cannot be formed, return -1
        if (dp[amount] == amount + 1) {
            return -1;
        }

        return dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = coinChange(coins, amount);

        System.out.println("Minimum coins: " + result);
    }
}