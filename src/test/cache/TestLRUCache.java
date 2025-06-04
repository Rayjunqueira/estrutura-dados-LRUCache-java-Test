package test.cache;

import main.java.cache.LRUCache;

public class TestLRUCache {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache(0)<>(2);
        cache.put(1, "One");
        cache.put(2, "Two");

        System.out.println("Get 1: " + cache.get(1));  // Deve ser "One"
        System.out.println("Get 2: " + cache.get(2));  // Deve ser "Two"

        cache.put(3, "Three");
        System.out.println("Get 2 (deve ser null): " + cache.get(2));  // Removido LRU
    }
}