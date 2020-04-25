package com.bugbean.arithmetic;

public class LruCache<K, V> {
    class Node<K, V> {
        Node<K, V> pre;
        Node<K, V> next;
        K key;
        V value;

        Node() {
        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V> head;
    private Node<K, V> tail;

    /**
     * 最大容量
     */
    private int capacity;
    /**
     * 当前大小
     */
    private int size;

    public LruCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new Node<K, V>();
        tail = new Node<K, V>();
        head.next = tail;
        tail.pre = head;
    }

    public void put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        Node<K, V> node = getNode(key);
        addToHead(newNode);
        if (node == null) {
            if (size > capacity) {
                removeTail();
            }
        } else {
            remove(node);
        }

    }

    /**
     * get
     *
     * @param key
     * @return
     */
    public V get(K key) {
        //这里可以通过加hash表来加快查询效率
        Node<K, V> node = getNode(key);
        if (node != null) {
            remove(node);
            addToHead(node);
            return node.value;
        }
        return null;
    }

    private void remove(Node<K, V> node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
        node.next = null;
        node.pre = null;
        size--;
    }

    private Node<K, V> getNode(K key) {
        Node<K, V> p = this.head.next;
        while (p != null) {
            if (p.key == key) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    private void addToHead(Node<K, V> node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        size++;
    }

    private void removeTail() {
        Node<K, V> p = tail.pre;
        tail.pre = p.pre;
        p.pre.next = tail;
        p.next = null;
        p.pre = null;
        size--;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<K, V> p = head.next;
        while (p.next != null) {
            builder.append("[");
            builder.append(p.key);
            builder.append(",");
            builder.append(p.value);
            builder.append("]");
            builder.append("<-->");
            p = p.next;
        }
        builder.append("null");
        return builder.toString();
    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(5);
        for (int i = 0; i < 10; i++) {
            lruCache.put(i, i);
        }
        System.out.println(lruCache);
        System.out.println(lruCache.get(6));
        System.out.println(lruCache);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */