package com.practice.basics;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem: LRU Cache
 *
 * Difficulty: Hard ⭐⭐⭐⭐⭐
 *
 * Question:
 * Design a cache that follows the Least Recently Used policy.
 *
 * Operations:
 *     get(key)
 *     put(key, value)
 *
 * Both operations should run in O(1).
 *
 * Example:
 *
 * Capacity = 2
 *
 * put(1, 10)
 * put(2, 20)
 * get(1)       -> 10
 * put(3, 30)   -> removes key 2
 * get(2)       -> -1
 *
 * Time Complexity:
 *     get() = O(1)
 *     put() = O(1)
 *
 * Space Complexity: O(capacity)
 */

public class LRUCache {

    /*
     * Node of the doubly linked list.
     */
    private static class Node {

        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    /*
     * Maps key -> corresponding linked-list node.
     */
    private final Map<Integer, Node> map;

    /*
     * Dummy head and tail nodes.
     *
     * Head -> Most Recently Used
     * Tail -> Least Recently Used
     */
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    /*
     * Get value associated with key.
     */
    public int get(int key) {

        Node node = map.get(key);

        // Key doesn't exist
        if (node == null) {
            return -1;
        }

        /*
         * Since this key was just accessed,
         * it becomes the most recently used.
         */
        remove(node);
        addToFront(node);

        return node.value;
    }

    /*
     * Insert or update a key-value pair.
     */
    public void put(int key, int value) {

        Node node = map.get(key);

        /*
         * Key already exists.
         */
        if (node != null) {

            node.value = value;

            // Mark as recently used
            remove(node);
            addToFront(node);

            return;
        }

        /*
         * Create new node.
         */
        Node newNode = new Node(key, value);

        map.put(key, newNode);

        // New node is most recently used
        addToFront(newNode);

        /*
         * Cache is too large.
         */
        if (map.size() > capacity) {

            // Remove least recently used node
            Node lruNode = tail.prev;

            remove(lruNode);

            map.remove(lruNode.key);
        }
    }

    /*
     * Remove a node from the linked list.
     */
    private void remove(Node node) {

        Node previous = node.prev;
        Node next = node.next;

        previous.next = next;
        next.prev = previous;
    }

    /*
     * Add a node immediately after head.
     *
     * This makes it the most recently used node.
     */
    private void addToFront(Node node) {

        Node firstNode = head.next;

        node.next = firstNode;
        node.prev = head;

        head.next = node;
        firstNode.prev = node;
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1));

        cache.put(3, 30);

        System.out.println(cache.get(2));

        cache.put(4, 40);

        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}