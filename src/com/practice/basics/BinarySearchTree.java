/*
Difficulty: Easy

Average Time Complexity:
    Insert -> O(log n)
    Search -> O(log n)

Worst Case Time Complexity:
    Insert -> O(n)
    Search -> O(n)

Space Complexity: O(n)

Question:
Implement a Binary Search Tree (BST) with the following operations:

1. Insert an element
2. Search for an element
3. Inorder Traversal

BST Rule:
- Values smaller than the root go to the left.
- Values greater than the root go to the right.

Example:

Input:
50 30 70 20 40 60 80

Inorder Output:
20 30 40 50 60 70 80

Search:
40 -> Found
90 -> Not Found
*/

package com.practice.basics;

import java.util.Scanner;

public class BinarySearchTree {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    // Insert a new value
    public Node insert(Node root, int data) {

        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Search for a value
    public boolean search(Node root, int target) {

        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        }

        if (target < root.data) {
            return search(root.left, target);
        }

        return search(root.right, target);
    }

    // Inorder traversal
    public void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BinarySearchTree bst = new BinarySearchTree();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            bst.root = bst.insert(bst.root, value);
        }

        System.out.println("Inorder Traversal:");

        bst.inorder(bst.root);

        System.out.println();

        System.out.print("Enter element to search: ");
        int target = sc.nextInt();

        if (bst.search(bst.root, target)) {
            System.out.println(target + " found in BST");
        } else {
            System.out.println(target + " not found in BST");
        }

        sc.close();
    }
}