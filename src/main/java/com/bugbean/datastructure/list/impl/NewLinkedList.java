package com.bugbean.datastructure.list.impl;

import com.bugbean.datastructure.list.List;

public class NewLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> current;

    public NewLinkedList() {
        head = new Node<>();
        current = head;
    }

    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);

    }

    @Override
    public void add(int index, E e) {

    }

    @Override
    public void remove(E e) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    private class Node<E> {
        private E data;
        private Node<E> next;

        Node() {
        }

        Node(E e) {
            data = e;
        }


        @Override
        public String toString() {
            return data.toString();
        }
    }
}
