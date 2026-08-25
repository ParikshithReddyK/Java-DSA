/*
Difficulty: Easy
Time Complexity:
    Push  -> O(1)
    Pop   -> O(1)
    Peek  -> O(1)

Space Complexity: O(n)

Question:
Implement a Stack using an array.

The Stack should support:
1. Push - Add an element to the top.
2. Pop  - Remove the top element.
3. Peek - View the top element without removing it.
4. Display - Display all elements.

Example:
Push: 10
Push: 20
Push: 30

Stack:
30 20 10

Pop:
30

Peek:
20
*/

package com.practice.basics;

import java.util.Scanner;

public class StackUsingArray {

    private int[] stack;
    private int top;
    private int capacity;

    public StackUsingArray(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    // Add an element to the stack
    public void push(int value) {

        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        stack[++top] = value;

        System.out.println(value + " pushed into stack");
    }

    // Remove the top element
    public void pop() {

        if (top == -1) {
            System.out.println("Stack Underflow");
            return;
        }

        System.out.println(stack[top] + " popped from stack");

        top--;
    }

    // View the top element
    public void peek() {

        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Top element: " + stack[top]);
    }

    // Display the stack
    public void display() {

        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Stack elements:");

        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack capacity: ");
        int capacity = sc.nextInt();

        StackUsingArray stack = new StackUsingArray(capacity);

        int choice;

        do {
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    stack.peek();
                    break;

                case 4:
                    stack.display();
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