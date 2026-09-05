package com.practice.basics;

/*
 * Kth Smallest Element in a Binary Search Tree
 *
 * Difficulty: Medium
 *
 * Time Complexity: O(h + k)
 * Space Complexity: O(h)
 *
 * Question:
 * Given a Binary Search Tree and an integer k,
 * find the kth smallest element.
 *
 * Example:
 *
 *         5
 *        / \
 *       3   7
 *      / \ / \
 *     2  4 6  8
 *
 * Inorder:
 * 2 3 4 5 6 7 8
 *
 * k = 3
 * Output: 4
 */

public class KthSmallestElementBST {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static int count;
    static int result;

    public static void findKthSmallest(Node root, int k) {

        if (root == null) {
            return;
        }

        // Visit left subtree
        findKthSmallest(root.left, k);

        // Process current node
        count++;

        if (count == k) {
            result = root.data;
            return;
        }

        // Visit right subtree
        findKthSmallest(root.right, k);
    }

    public static int kthSmallest(Node root, int k) {

        count = 0;
        result = -1;

        findKthSmallest(root, k);

        return result;
    }

    public static void main(String[] args) {

        /*
         * Creating BST:
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

        int k = 3;

        int result = kthSmallest(root, k);

        System.out.println(
                k + "rd smallest element: " + result
        );
    }
}