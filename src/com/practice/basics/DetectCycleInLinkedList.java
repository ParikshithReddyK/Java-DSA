/*
Difficulty: Medium

Time Complexity: O(n)
Space Complexity: O(1)

Question:
Given a singly linked list, determine whether the linked list
contains a cycle.

A cycle exists when a node points back to a previous node
instead of pointing to null.

Example:

10 -> 20 -> 30 -> 40
          ↑         |
          |---------|

Output:
Cycle detected

Example without cycle:

10 -> 20 -> 30 -> 40 -> null

Output:
No cycle detected
*/

package com.practice.basics;

import java.util.Scanner;

public class DetectCycleInLinkedList {

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

    // Create a cycle by connecting the last node
    // to the node at the given position
    public void createCycle(int position) {

        if (head == null || position < 0) {
            return;
        }

        Node cycleNode = head;

        for (int i = 0; i < position; i++) {

            if (cycleNode == null) {
                return;
            }

            cycleNode = cycleNode.next;
        }

        Node last = head;

        while (last.next != null) {
            last = last.next;
        }

        last.next = cycleNode;
    }

    // Floyd's Cycle Detection Algorithm
    public boolean hasCycle() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DetectCycleInLinkedList list = new DetectCycleInLinkedList();

        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            list.insert(sc.nextInt());
        }

        System.out.print(
                "Enter cycle position (-1 for no cycle): "
        );

        int position = sc.nextInt();

        if (position != -1) {
            list.createCycle(position);
        }

        if (list.hasCycle()) {
            System.out.println("Cycle detected");
        } else {
            System.out.println("No cycle detected");
        }

        sc.close();
    }
}