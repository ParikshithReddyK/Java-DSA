package com.practice.basics;

/*
 * Lowest Common Ancestor in Binary Search Tree
 *
 * Difficulty: Medium
 *
 * Time Complexity: O(h)
 * Space Complexity: O(h) - recursion stack
 *
 * Question:
 * Given a Binary Search Tree and two nodes p and q,
 * find their Lowest Common Ancestor (LCA).
 *
 * Example:
 *
 *           6
 *          / \
 *         2   8
 *        / \ / \
 *       0  4 7  9
 *         / \
 *        3   5
 *
 * p = 2, q = 8
 * Output: 6
 */

public class LowestCommonAncestorBST {

    // Node of Binary Search Tree
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Find Lowest Common Ancestor
    public static Node findLCA(Node root, int p, int q) {

        if (root == null) {
            return null;
        }

        // Both nodes are smaller than root
        if (p < root.data && q < root.data) {
            return findLCA(root.left, p, q);
        }

        // Both nodes are greater than root
        if (p > root.data && q > root.data) {
            return findLCA(root.right, p, q);
        }

        // Nodes are on different sides,
        // or one node is the current root
        return root;
    }

    public static void main(String[] args) {

        /*
         * Creating the BST
         *
         *           6
         *          / \
         *         2   8
         *        / \ / \
         *       0  4 7  9
         *         / \
         *        3   5
         */

        Node root = new Node(6);

        root.left = new Node(2);
        root.right = new Node(8);

        root.left.left = new Node(0);
        root.left.right = new Node(4);

        root.right.left = new Node(7);
        root.right.right = new Node(9);

        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);

        int p = 2;
        int q = 8;

        Node lca = findLCA(root, p, q);

        if (lca != null) {
            System.out.println("Lowest Common Ancestor: " + lca.data);
        } else {
            System.out.println("LCA not found");
        }
    }
}