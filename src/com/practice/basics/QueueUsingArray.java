/*
Difficulty: Easy

Time Complexity:
    Enqueue -> O(1)
    Dequeue -> O(n)
    Peek    -> O(1)

Space Complexity: O(n)

Question:
Implement a Queue using an array.

The Queue should support:
1. Enqueue - Add an element to the rear.
2. Dequeue - Remove an element from the front.
3. Peek    - View the front element.
4. Display - Display all elements.

Example:
Enqueue: 10
Enqueue: 20
Enqueue: 30

Queue:
10 20 30

Dequeue:
10

Peek:
20
*/

package com.practice.basics;

import java.util.Scanner;

public class QueueUsingArray {

    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
    }

    // Add an element to the rear
    public void enqueue(int value) {

        if (rear == capacity - 1) {
            System.out.println("Queue Overflow");
            return;
        }

        queue[++rear] = value;

        System.out.println(value + " added to queue");
    }

    // Remove an element from the front
    public void dequeue() {

        if (front > rear) {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println(queue[front] + " removed from queue");

        front++;
    }

    // View the front element
    public void peek() {

        if (front > rear) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Front element: " + queue[front]);
    }

    // Display the queue
    public void display() {

        if (front > rear) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Queue elements:");

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue capacity: ");
        int capacity = sc.nextInt();

        QueueUsingArray queue = new QueueUsingArray(capacity);

        int choice;

        do {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    queue.enqueue(value);
                    break;

                case 2:
                    queue.dequeue();
                    break;

                case 3:
                    queue.peek();
                    break;

                case 4:
                    queue.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}