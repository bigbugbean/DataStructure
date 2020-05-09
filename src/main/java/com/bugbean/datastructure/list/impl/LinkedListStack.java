package com.bugbean.datastructure.list.impl;

import com.bugbean.datastructure.list.Stack;

/**
 * 链式栈
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public class LinkedListStack<E> implements Stack<E> {

    class Node<E> {
        private E data;
        private Node<E> pre;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public Node() {

        }
    }

    private Node<E> head;
    private Node<E> tail;

    public LinkedListStack() {
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.pre = head;
    }

    @Override
    public void push(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = tail;
        newNode.pre = tail.pre;
        tail.pre.next = newNode;
        tail.pre = newNode;
    }

    @Override
    public E pop() {
        Node<E> node = tail.pre;
        node.pre.next = tail;
        tail.pre = node.pre;
        node.pre = null;
        node.next = null;

        return node.data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> p = head.next;
        while (p.next != null) {
            builder.append("[");
            builder.append(p.data);
            builder.append("]");
            builder.append("<-->");
            p = p.next;
        }
        builder.append("null");
        return builder.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }
    }
}
