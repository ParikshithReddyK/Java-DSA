package com.practice.basics;

/*
 * Validate Binary Search Tree
 *
 * Difficulty: Medium
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * Question:
 * Given a binary tree, determine whether it is a valid BST.
 *
 * For every node:
 *   left subtree values < node value
 *   right subtree values > node value
 *
 * Example:
 *
 *         5
 *        / \
 *       3   7
 *      / \ / \
 *     2  4 6  8
 *
 * Output:
 * Valid BST: true
 */

public class ValidateBinarySearchTree {

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
     * Validate the tree using a minimum and maximum range.
     */
    public static boolean isValidBST(Node root, long min, long max) {

        // Empty tree is a valid BST
        if (root == null) {
            return true;
        }

        // Current node must be inside the allowed range
        if (root.data <= min || root.data >= max) {
            return false;
        }

        // Left subtree must contain values smaller than root
        boolean leftValid = isValidBST(root.left, min, root.data);

        // Right subtree must contain values greater than root
        boolean rightValid = isValidBST(root.right, root.data, max);

        return leftValid && rightValid;
    }

    public static boolean isValidBST(Node root) {

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {

        /*
         * Creating the BST
         *
         *         5
         *        / \
         *       3   7
         *      / \ / \
         *     2  4 6  8
         */

        Node root = new Node(5);

        root.left = new Node(3);
        root.right = new Node(7);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right.left = new Node(6);
        root.right.right = new Node(8);

        System.out.println("Valid BST: " + isValidBST(root));
    }
}