package com.bugbean.arithmetic;

import java.util.concurrent.ConcurrentHashMap;

public class LRUCacheWithHashTable {

    class Node {
        Node pre;
        Node next;
        int key = -1;
        int value = -1;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private ConcurrentHashMap<Integer, Node> cache = new ConcurrentHashMap<>();

    /**
     * 最大容量
     */
    private int capacity;
    /**
     * 当前大小
     */
    private int size;

    public LRUCacheWithHashTable(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {

        Node node = cache.get(key);

        if (node == null) {
            Node newNode = new Node(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
            if (size > capacity) {
                removeTail();
            }
        } else {
            node.value = value;
            remove(node);
            addToHead(node);
        }
    }

    /**
     * get
     *
     * @param key
     * @return
     */
    public int get(int key) {
        //这里可以通过加hash表来加快查询效率
        Node node = cache.get(key);
        if (node != null) {
            remove(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    private void remove(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
        node.next = null;
        node.pre = null;
        size--;
    }

    private Node getNode(int key) {
        Node p = this.head.next;
        while (p != null) {
            if (p.key == key) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    private void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        size++;
    }

    private void removeTail() {
        Node p = tail.pre;
        tail.pre = p.pre;
        p.pre.next = tail;
        p.next = null;
        p.pre = null;
        size--;
        cache.remove(p.key);
    }

    public static void main(String[] args) {
        LRUCacheWithHashTable lruCache = new LRUCacheWithHashTable(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */