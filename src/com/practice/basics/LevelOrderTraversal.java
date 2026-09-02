/*
 * Level Order Traversal of Binary Tree
 *
 * Difficulty: Medium
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Question:
 * Given a binary tree, print all nodes level by level
 * from left to right.
 *
 * Example:
 *
 *         1
 *        / \
 *       2   3
 *      / \   \
 *     4   5   6
 *
 * Output:
 * 1 2 3 4 5 6
 */

package com.practice.basics;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    // Node of Binary Tree
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Level Order Traversal using BFS
    public static void levelOrder(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        // Add root to the queue
        queue.add(root);

        while (!queue.isEmpty()) {

            // Remove the front node
            Node current = queue.poll();

            System.out.print(current.data + " ");

            // Add left child
            if (current.left != null) {
                queue.add(current.left);
            }

            // Add right child
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {

        // Creating the binary tree
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        System.out.println("Level Order Traversal:");

        levelOrder(root);
    }
}