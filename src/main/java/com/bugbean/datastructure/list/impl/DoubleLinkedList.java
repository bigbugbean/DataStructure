package com.bugbean.datastructure.list.impl;

import com.bugbean.datastructure.list.List;

/**
 * @author dugm
 * @description
 * @date 2019-07-08 16:19
 */
public class DoubleLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;

    /**
     * 添加末尾元素
     *
     * @param e
     */
    @Override
    public void add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }

        Node<E> node = new Node<>(e, tail, null);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    /**
     * 中间插入元素
     *
     * @param index
     * @param e
     */
    @Override
    public void add(int index, E e) {
        Node<E> curr = this.head;
        Node<E> node = new Node<>(e, curr.prev, curr);
        if (index == 0) {
            head = node;
            return;
        }

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.prev.next = node;
        curr.prev = node;
    }

    /**
     * 移除元素
     *
     * @param e
     */
    @Override
    public void remove(E e) {
        if (head.data.equals(e)) {
            head = head.next;
            return;
        }

        Node node = this.head;
        while (node != null) {
            Node next = node.next;
            if (next.data.equals(e)) {
                node.next = next.next;
                next.next = null;
                return;
            }
            node = next;
        }
    }

    /**
     * 移除元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        Node<E> curr = element(index);

        if (index == 0) {
            head = curr.next;
            curr.next = null;
            return curr.data;
        }

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        curr.prev = null;
        curr.next = null;
        return curr.data;
    }

    /**
     * 获取元素
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return element(index).data;
    }

    private Node<E> element(int index) {
        Node<E> curr = this.head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    private class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    @Override
    public String toString() {
        Node node = this.head;
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (node != null) {
            builder.append(node);
            builder.append("<->");
            node = node.next;
        }
        return builder.substring(0, builder.length() - 3) + "]";
    }

    public static void main(String[] args) {
        DoubleLinkedList<Long> list = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add((long) i);
        }

        System.out.println(list);

        list.add(0, 100L);
        System.out.println(list);

        System.out.println(list.get(2));

        list.remove(9L);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);
    }
}
