package com.practice.basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Course Schedule
 *
 * Difficulty: Medium
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 *
 * Question:
 * Given numCourses and prerequisite pairs,
 * determine whether it is possible to finish all courses.
 *
 * prerequisite [a, b] means:
 * To take course a, you must first complete course b.
 *
 * Example:
 *
 * numCourses = 2
 * prerequisites = [[1, 0]]
 *
 * Graph:
 * 0 -> 1
 *
 * Output:
 * true
 *
 * Example 2:
 *
 * prerequisites = [[1, 0], [0, 1]]
 *
 * Graph contains a cycle.
 *
 * Output:
 * false
 */

public class CourseSchedule {

    public static boolean canFinish(
            int numCourses,
            int[][] prerequisites) {

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Indegree of every course
        int[] indegree = new int[numCourses];

        /*
         * Build graph.
         *
         * [1, 0] means:
         * 0 -> 1
         */
        for (int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];

            graph.get(prerequisiteCourse).add(course);

            indegree[course]++;
        }

        // Queue contains courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int completedCourses = 0;

        // BFS / Topological Sort
        while (!queue.isEmpty()) {

            int currentCourse = queue.poll();

            completedCourses++;

            // Process courses dependent on current course
            for (int nextCourse : graph.get(currentCourse)) {

                indegree[nextCourse]--;

                // All prerequisites completed
                if (indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        /*
         * If we completed every course,
         * there is no cycle.
         */
        return completedCourses == numCourses;
    }

    public static void main(String[] args) {

        int numCourses = 4;

        int[][] prerequisites = {
                {1, 0},
                {2, 1},
                {3, 2}
        };

        boolean result = canFinish(
                numCourses,
                prerequisites
        );

        System.out.println("Can finish all courses: " + result);
    }
}