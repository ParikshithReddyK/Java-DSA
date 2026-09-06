package com.practice.basics;

/*
 * Flood Fill
 *
 * Difficulty: Easy-Medium
 *
 * Time Complexity: O(rows * columns)
 * Space Complexity: O(rows * columns)
 *
 * Question:
 * Given a 2D image, starting row, starting column,
 * and a new color, replace the starting cell and all
 * connected cells having the same original color.
 *
 * Cells are connected horizontally or vertically.
 *
 * Example:
 *
 * Input:
 * 1 1 1
 * 1 1 0
 * 1 0 1
 *
 * sr = 1, sc = 1
 * newColor = 2
 *
 * Output:
 * 2 2 2
 * 2 2 0
 * 2 0 1
 */

public class FloodFill {

    public static void dfs(int[][] image, int row, int col,
                           int originalColor, int newColor) {

        // Check boundaries
        if (row < 0 || row >= image.length ||
            col < 0 || col >= image[0].length) {
            return;
        }

        // Stop if the cell has a different color
        if (image[row][col] != originalColor) {
            return;
        }

        // Change the color
        image[row][col] = newColor;

        // Move up
        dfs(image, row - 1, col, originalColor, newColor);

        // Move down
        dfs(image, row + 1, col, originalColor, newColor);

        // Move left
        dfs(image, row, col - 1, originalColor, newColor);

        // Move right
        dfs(image, row, col + 1, originalColor, newColor);
    }

    public static void floodFill(int[][] image, int sr, int sc,
                                 int newColor) {

        int originalColor = image[sr][sc];

        // If colors are already the same, nothing needs to be done
        if (originalColor == newColor) {
            return;
        }

        dfs(image, sr, sc, originalColor, newColor);
    }

    public static void printImage(int[][] image) {

        for (int row = 0; row < image.length; row++) {

            for (int col = 0; col < image[0].length; col++) {
                System.out.print(image[row][col] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int sr = 1;
        int sc = 1;
        int newColor = 2;

        floodFill(image, sr, sc, newColor);

        System.out.println("After Flood Fill:");

        printImage(image);
    }
}