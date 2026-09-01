/*
Difficulty: Easy

Time Complexity: O(n)
Space Complexity: O(n)

Question:
Create a Binary Tree and perform the following traversals:

1. Inorder Traversal  -> Left, Root, Right
2. Preorder Traversal -> Root, Left, Right
3. Postorder Traversal -> Left, Right, Root

Example Tree:

        1
       / \
      2   3
     / \
    4   5

Output:

Inorder:
4 2 5 1 3

Preorder:
1 2 4 5 3

Postorder:
4 5 2 3 1
*/

package com.practice.basics;

public class BinaryTreeTraversal {

    // Node of the Binary Tree
    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Inorder: Left -> Root -> Right
    public static void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    // Preorder: Root -> Left -> Right
    public static void preorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preorder(root.left);

        preorder(root.right);
    }

    // Postorder: Left -> Right -> Root
    public static void postorder(Node root) {

        if (root == null) {
            return;
        }

        postorder(root.left);

        postorder(root.right);

        System.out.print(root.data + " ");
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

        System.out.println("Inorder Traversal:");
        inorder(root);

        System.out.println();

        System.out.println("Preorder Traversal:");
        preorder(root);

        System.out.println();

        System.out.println("Postorder Traversal:");
        postorder(root);

        System.out.println();
    }
}