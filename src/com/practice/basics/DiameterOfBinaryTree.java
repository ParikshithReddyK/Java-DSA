package com.practice.basics;

/*
 * Diameter of a Binary Tree
 *
 * Difficulty: Medium
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * Question:
 * Find the diameter of a binary tree.
 *
 * The diameter is the longest path between any two nodes.
 * The answer is measured in number of edges.
 *
 * Example:
 *
 *          1
 *         / \
 *        2   3
 *       / \
 *      4   5
 *
 * Longest path:
 * 4 -> 2 -> 1 -> 3
 *
 * Diameter = 3
 */

public class DiameterOfBinaryTree {

    // Node of Binary Tree
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Stores the maximum diameter found
    static int diameter = 0;

    // Returns height and updates diameter
    public static int height(Node root) {

        if (root == null) {
            return -1;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        /*
         * Longest path passing through current node:
         *
         * leftHeight + rightHeight + 2
         */
        int currentDiameter = leftHeight + rightHeight + 2;

        diameter = Math.max(diameter, currentDiameter);

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static int findDiameter(Node root) {

        diameter = 0;

        height(root);

        return diameter;
    }

    public static void main(String[] args) {

        /*
         * Creating the binary tree
         *
         *          1
         *         / \
         *        2   3
         *       / \
         *      4   5
         */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int result = findDiameter(root);

        System.out.println("Diameter of Binary Tree: " + result);
    }
}