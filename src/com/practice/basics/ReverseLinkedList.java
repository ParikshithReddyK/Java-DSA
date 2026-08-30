/*
Difficulty: Easy

Time Complexity: O(n)
Space Complexity: O(1)

Question:
Given a singly linked list, reverse the linked list
and return the new head.

Example:

Input:
10 -> 20 -> 30 -> 40 -> null

Output:
40 -> 30 -> 20 -> 10 -> null
*/

package com.practice.basics;

import java.util.Scanner;

public class ReverseLinkedList {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Insert a node at the end
    public void insert(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Reverse the linked list
    public void reverse() {

        Node previous = null;
        Node current = head;

        while (current != null) {

            Node nextNode = current.next;

            current.next = previous;

            previous = current;
            current = nextNode;
        }

        head = previous;
    }

    // Display the linked list
    public void display() {

        Node current = head;

        while (current != null) {

            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ReverseLinkedList list = new ReverseLinkedList();

        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            list.insert(sc.nextInt());
        }

        System.out.println("Original Linked List:");
        list.display();

        list.reverse();

        System.out.println("Reversed Linked List:");
        list.display();

        sc.close();
    }
}