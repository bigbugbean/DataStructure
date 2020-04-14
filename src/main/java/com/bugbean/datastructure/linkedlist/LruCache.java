package com.bugbean.datastructure.linkedlist;

public class LruCache {
    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    private Node head;

    private int cacheSize = 0;
    private int maxSize = 10;

    public void add(int value) {

        Node newNode = new Node(value);
        if (head != null) {
            Node p = head;
            Node tmp = head;
            while (p.next != null) {
                tmp = p;
                p = p.next;
                //若新增元素在缓存中，把原来的删除
                if (p.data == value) {
                    tmp.next = p.next;
                    p.next = null;
                    break;
                }
            }

            //若新增元素没有在缓存中
            if (cacheSize >= maxSize) {
                tmp.next = null;
            }
            newNode.next = head;
        }

        //头插新节点
        head = newNode;
        cacheSize++;
    }

    @Override
    public String toString() {
        Node node = this.head;
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (node != null) {
            builder.append(node);
            builder.append("->");
            node = node.next;
        }
        return builder.substring(0, builder.length() - 2) + "]";
    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache();
        lruCache.add(1);
        lruCache.add(2);
        lruCache.add(3);
        lruCache.add(4);
        lruCache.add(5);
        lruCache.add(1);
        System.out.println(lruCache);
    }
}
