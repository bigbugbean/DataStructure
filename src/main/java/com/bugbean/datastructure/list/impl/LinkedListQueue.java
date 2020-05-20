package com.bugbean.datastructure.list.impl;

import com.bugbean.datastructure.list.Queue;

/**
 * 链式队列
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public class LinkedListQueue<E> implements Queue<E> {

    private Node<E> head;
    private Node<E> tail;

    class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    @Override
    public boolean enqueue(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = tail = newNode;
            return true;
        }
        tail.next = newNode;
        tail = newNode;
        return true;
    }

    @Override
    public E dequeue() {
        if (head == null){
            return null;
        }
        E e = head.data;
        head = head.next;
        return e;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> p = head;
        while (p != null) {
            builder.append("[");
            builder.append(p.data);
            builder.append("]");
            builder.append("->");
            p = p.next;
        }
        builder.append("null");
        return builder.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 30; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
    }
}
