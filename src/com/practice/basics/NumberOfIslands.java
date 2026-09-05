package com.practice.basics;

/*
 * Number of Islands
 *
 * Difficulty: Medium
 *
 * Time Complexity: O(rows * columns)
 * Space Complexity: O(rows * columns)
 *
 * Question:
 * Given a 2D grid containing '1' (land) and '0' (water),
 * count the number of islands.
 *
 * Cells are connected horizontally or vertically.
 *
 * Example:
 *
 * 1 1 0 0 0
 * 1 1 0 0 0
 * 0 0 1 0 0
 * 0 0 0 1 1
 *
 * Output:
 * 3
 */

public class NumberOfIslands {

    // DFS to visit the complete island
    public static void dfs(char[][] grid, int row, int col) {

        // Check boundaries
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length) {
            return;
        }

        // Stop if this cell is water
        if (grid[row][col] == '0') {
            return;
        }

        // Mark the land cell as visited
        grid[row][col] = '0';

        // Move up
        dfs(grid, row - 1, col);

        // Move down
        dfs(grid, row + 1, col);

        // Move left
        dfs(grid, row, col - 1);

        // Move right
        dfs(grid, row, col + 1);
    }

    public static int countIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int islands = 0;

        for (int row = 0; row < grid.length; row++) {

            for (int col = 0; col < grid[0].length; col++) {

                // Found a new island
                if (grid[row][col] == '1') {

                    islands++;

                    // Visit the entire island
                    dfs(grid, row, col);
                }
            }
        }

        return islands;
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int result = countIslands(grid);

        System.out.println("Number of Islands: " + result);
    }
}