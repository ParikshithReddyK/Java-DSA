/*
Difficulty: Medium

Time Complexity:
    Enqueue -> O(1)
    Dequeue -> O(n) worst case

Space Complexity: O(n)

Question:
Implement a Queue using two Stacks.

A Queue follows FIFO (First In, First Out),
while a Stack follows LIFO (Last In, First Out).

Example:

Enqueue:
10
20
30

Queue:
10 20 30

Dequeue:
10

Queue:
20 30
*/

package com.practice.basics;

import java.util.Stack;
import java.util.Scanner;

public class QueueUsingTwoStacks {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Add element to the queue
    public void enqueue(int value) {

        stack1.push(value);

        System.out.println(value + " added to queue");
    }

    // Remove element from the queue
    public void dequeue() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        // Move elements only when stack2 is empty
        if (stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        System.out.println(stack2.pop() + " removed from queue");
    }

    // View front element
    public void peek() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        if (stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        System.out.println("Front element: " + stack2.peek());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        int choice;

        do {

            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Exit");

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
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}