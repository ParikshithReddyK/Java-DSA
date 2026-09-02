/*
Difficulty: Easy

Time Complexity: O(n)
Space Complexity: O(h)
where h is the height of the tree due to recursion.

Question:
Given a binary tree, find its height.

The height is the number of edges on the longest path
from the root node to a leaf node.

Example:

        1
       / \
      2   3
     / \
    4   5

Output:
Height of Binary Tree: 2
*/

package com.practice.basics;

public class HeightOfBinaryTree {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Find height of the binary tree
    public static int height(Node root) {

        // Empty tree has height -1
        if (root == null) {
            return -1;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \
             4   5
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(
                "Height of Binary Tree: " + height(root)
        );
    }
}