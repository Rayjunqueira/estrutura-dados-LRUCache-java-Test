package main.java.cache;

import java.util.*;

public class LRUCache<K, V> {
    private final int capacity;
    private Map<K, Node> map;
    private DoublyLinkedList dll;

    private class Node {
        K key;
        V value;
        Node prev, next;
        Node(K k, V v) { key = k; value = v; }
    }

    private class DoublyLinkedList {
        Node head, tail;

        DoublyLinkedList() {
            head = new Node(null, null);
            tail = new Node(null, null);
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        Node removeLast() {
            if (tail.prev == head) return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dll = new DoublyLinkedList();
    }

    public V get(K key) {
        if (!map.containsKey(key)) return null;

        Node node = map.get(key);
        dll.remove(node);
        dll.addFirst(node);
        return node.value;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            dll.remove(node);
            dll.addFirst(node);
        } else {
            if (map.size() == capacity) {
                Node last = dll.removeLast();
                if (last != null) {
                    map.remove(last.key);
                }
            }
            Node newNode = new Node(key, value);
            dll.addFirst(newNode);
            map.put(key, newNode);
        }
    }

    public void printCache() {
        Node current = dll.head.next;
        System.out.print("Cache state: ");
        while (current != dll.tail) {
            System.out.print("(" + current.key + ":" + current.value + ") ");
            current = current.next;
        }
        System.out.println();
    }
};
