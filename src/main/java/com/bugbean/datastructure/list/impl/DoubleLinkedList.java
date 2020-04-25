package com.bugbean.datastructure.list.impl;

import com.bugbean.datastructure.list.LinkedList;

/**
 * 双向链表
 *
 * @author dugm
 * @Description
 */
public class DoubleLinkedList<E> implements LinkedList<E> {

    protected Node<E> head;
    protected Node<E> tail;

    public DoubleLinkedList() {
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.pre = head;
    }

    protected class Node<E> {
        public Node<E> pre;
        public Node<E> next;
        public E data;

        public Node() {
        }

        public Node(E data) {
            this.data = data;
        }
    }

    @Override
    public void add(int index, E e) {
        Node<E> p = getNode(index);
        Node<E> newNode = new Node<>(e);
        newNode.next = p;
        newNode.pre = p.pre;
        p.pre.next = newNode;
        p.pre = newNode;
    }

    @Override
    public void remove(int index) {
        Node<E> p = getNode(index);
        p.pre.next = p.next;
        p.next.pre = p.pre;
        p.pre = null;
        p.next = null;
    }

    @Override
    public void set(int index, E e) {
        Node<E> p = getNode(index);
        p.data = e;
    }

    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    private Node<E> getNode(int index) {
        Node<E> p = this.head;
        for (int i = 0; i < index + 1; i++) {
            p = p.next;
            if (p == null) {
                throw new RuntimeException("超过当前列表大小");
            }
        }
        return p;
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
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            doubleLinkedList.add(i, i);
        }
        System.out.println(doubleLinkedList);
        doubleLinkedList.remove(5);
        System.out.println(doubleLinkedList);
        doubleLinkedList.set(2, 99);
        System.out.println(doubleLinkedList);
        System.out.println(doubleLinkedList.get(8));
    }
}
