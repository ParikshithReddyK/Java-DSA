package com.practice.basics;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Rotten Oranges
 *
 * Difficulty: Medium
 *
 * Time Complexity: O(rows * columns)
 * Space Complexity: O(rows * columns)
 *
 * Question:
 * Given a grid:
 *
 * 0 = Empty
 * 1 = Fresh Orange
 * 2 = Rotten Orange
 *
 * Every minute, a rotten orange makes adjacent fresh
 * oranges rotten.
 *
 * Find the minimum time required for all oranges to rot.
 *
 * Return -1 if some fresh oranges can never become rotten.
 *
 * Example:
 *
 * Input:
 * 2 1 1
 * 1 1 0
 * 0 1 1
 *
 * Output:
 * 4
 */

public class RottenOranges {

    // Represents a cell in the grid
    static class Cell {

        int row;
        int col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Cell> queue = new LinkedList<>();

        int freshOranges = 0;

        // Add all rotten oranges to the queue
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (grid[row][col] == 2) {
                    queue.add(new Cell(row, col));
                }

                if (grid[row][col] == 1) {
                    freshOranges++;
                }
            }
        }

        int minutes = 0;

        // Four possible directions
        int[] rowDirection = {-1, 1, 0, 0};
        int[] colDirection = {0, 0, -1, 1};

        // BFS
        while (!queue.isEmpty() && freshOranges > 0) {

            int size = queue.size();

            // Process all oranges at the current minute
            for (int i = 0; i < size; i++) {

                Cell current = queue.poll();

                for (int direction = 0; direction < 4; direction++) {

                    int newRow =
                            current.row + rowDirection[direction];

                    int newCol =
                            current.col + colDirection[direction];

                    // Check boundaries
                    if (newRow < 0 || newRow >= rows ||
                        newCol < 0 || newCol >= cols) {
                        continue;
                    }

                    // If fresh, make it rotten
                    if (grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;

                        freshOranges--;

                        queue.add(new Cell(newRow, newCol));
                    }
                }
            }

            minutes++;
        }

        // If fresh oranges remain, they cannot be reached
        if (freshOranges > 0) {
            return -1;
        }

        return minutes;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int result = orangesRotting(grid);

        System.out.println("Minutes required: " + result);
    }
}