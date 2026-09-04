package com.practice.basics;

/*
 * Check if Binary Tree is Balanced
 *
 * Difficulty: Easy-Medium
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * Question:
 * Determine whether a binary tree is height-balanced.
 *
 * A tree is balanced if the difference between the heights
 * of the left and right subtrees of every node is at most 1.
 *
 * Example:
 *
 *         1
 *        / \
 *       2   3
 *      / \
 *     4   5
 *
 * Output:
 * Balanced: true
 */

public class BalancedBinaryTree {

    // Node of Binary Tree
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    /*
     * Returns the height of the tree.
     *
     * If the tree is unbalanced, return -1.
     */
    public static int checkHeight(Node root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = checkHeight(root.left);

        // Left subtree is unbalanced
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(root.right);

        // Right subtree is unbalanced
        if (rightHeight == -1) {
            return -1;
        }

        // Check height difference
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static boolean isBalanced(Node root) {

        return checkHeight(root) != -1;
    }

    public static void main(String[] args) {

        /*
         * Creating the binary tree
         *
         *         1
         *        / \
         *       2   3
         *      / \
         *     4   5
         */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Balanced: " + isBalanced(root));
    }
}