/*
Difficulty: Easy

Time Complexity:
    Insert at Beginning -> O(1)
    Insert at End       -> O(n)
    Delete by Value     -> O(n)
    Search              -> O(n)
    Display             -> O(n)

Space Complexity: O(n)

Question:
Implement a Singly Linked List with the following operations:

1. Insert at Beginning
2. Insert at End
3. Delete an Element
4. Search for an Element
5. Display the List

Example:

Input:
10 -> 20 -> 30

Insert 5 at beginning:

5 -> 10 -> 20 -> 30

Insert 40 at end:

5 -> 10 -> 20 -> 30 -> 40

Delete 20:

5 -> 10 -> 30 -> 40
*/

package com.practice.basics;

import java.util.Scanner;

public class LinkedList {

    // Node represents one element in the linked list
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Insert at beginning
    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

        System.out.println(data + " inserted at beginning");
    }

    // Insert at end
    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            System.out.println(data + " inserted at end");
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        System.out.println(data + " inserted at end");
    }

    // Delete an element
    public void delete(int data) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // If the element is the head
        if (head.data == data) {
            head = head.next;
            System.out.println(data + " deleted from list");
            return;
        }

        Node current = head;

        while (current.next != null &&
                current.next.data != data) {

            current = current.next;
        }

        if (current.next == null) {
            System.out.println(data + " not found");
            return;
        }

        current.next = current.next.next;

        System.out.println(data + " deleted from list");
    }

    // Search for an element
    public void search(int data) {

        Node current = head;

        int position = 0;

        while (current != null) {

            if (current.data == data) {
                System.out.println(
                        data + " found at position " + position
                );
                return;
            }

            current = current.next;
            position++;
        }

        System.out.println(data + " not found");
    }

    // Display the list
    public void display() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;

        System.out.print("Linked List: ");

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

        LinkedList list = new LinkedList();

        int choice;

        do {

            System.out.println("\n1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Display");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int beginningValue = sc.nextInt();
                    list.insertAtBeginning(beginningValue);
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    int endValue = sc.nextInt();
                    list.insertAtEnd(endValue);
                    break;

                case 3:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = sc.nextInt();
                    list.delete(deleteValue);
                    break;

                case 4:
                    System.out.print("Enter value to search: ");
                    int searchValue = sc.nextInt();
                    list.search(searchValue);
                    break;

                case 5:
                    list.display();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}